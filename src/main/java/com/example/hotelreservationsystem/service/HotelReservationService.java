package com.example.hotelreservationsystem.service;



import com.example.hotelreservationsystem.model.CustomerType;
import com.example.hotelreservationsystem.model.Hotel;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;


public class HotelReservationService {
    private List<Hotel> hotels = new ArrayList<>();
    
    private static final String DATE_PATTERN = "^[0-9]{2}[A-Za-z]{3}[0-9]{4}$";
    private static final Pattern pattern = Pattern.compile(DATE_PATTERN);

    // Add a new hotel
    public void addHotel(Hotel hotel) {
        hotels.add(hotel);
    }

    // Retrieve all hotels
    public List<Hotel> getHotels() {
        return hotels;
    }
    
 // Helper: check if date is weekend
    private boolean isWeekend(LocalDate date) {
        DayOfWeek day = date.getDayOfWeek();
        return (day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY);
    }
    
    
 // Helper: Parse date strings into LocalDate
    private List<LocalDate> parseDates(String... dates) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMMyyyy", Locale.ENGLISH);
        List<LocalDate> parsedDates = new ArrayList<>();
        for (String date : dates) {
            parsedDates.add(LocalDate.parse(date, formatter));
        }
        return parsedDates;
    }

  
    
    private int calculateTotalCost(Hotel hotel, List<LocalDate> dates, CustomerType customerType) {
        return dates.stream()
                .mapToInt(date -> {
                    if (isWeekend(date)) {
                        return (customerType == CustomerType.REGULAR) ? hotel.getRegularWeekendRate() : hotel.getRewardWeekendRate();
                    } else {
                        return (customerType == CustomerType.REGULAR) ? hotel.getRegularWeekdayRate() : hotel.getRewardWeekdayRate();
                    }
                })
                .sum();
    }
     
    public Hotel findBestRatedHotel() {
        return hotels.stream()
                .max(Comparator.comparingInt(Hotel::getRating))
                .orElse(null);
    }
    

    // UC11: Find cheapest best rated hotel for Reward customer using streams
    public Hotel findCheapestBestRatedHotelForReward(String... dates) {
        List<LocalDate> parsedDates = parseDates(dates);

        return hotels.stream()
                .sorted(Comparator
                        .comparingInt((Hotel h) -> calculateTotalCost(h, parsedDates, CustomerType.REWARD))
                        .thenComparing(Hotel::getRating, Comparator.reverseOrder()))
                .findFirst()
                .orElse(null);
    }

 // Helper to also fetch total cost
    public int getTotalCost(Hotel hotel, String... dates) {
        List<LocalDate> parsedDates = parseDates(dates);
        return calculateTotalCost(hotel, parsedDates, CustomerType.REWARD);
    }
    
 // UC12: Find cheapest best rated hotel for Regular customer using streams
    public Hotel findCheapestBestRatedHotelForRegular(String... dates) {
        List<LocalDate> parsedDates = parseDates(dates);

        return hotels.stream()
                .sorted(Comparator
                        .comparingInt((Hotel h) -> calculateTotalCost(h, parsedDates, CustomerType.REGULAR))
                        .thenComparing(Hotel::getRating, Comparator.reverseOrder()))
                .findFirst()
                .orElse(null);
    }

    // Helper for Regular customer total cost
    public int getTotalCostForRegular(Hotel hotel, String... dates) {
        List<LocalDate> parsedDates = parseDates(dates);
        return calculateTotalCost(hotel, parsedDates, CustomerType.REGULAR);
    }
    
    
    
}
