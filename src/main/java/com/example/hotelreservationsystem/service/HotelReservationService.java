package com.example.hotelreservationsystem.service;



import com.example.hotelreservationsystem.model.Hotel;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;


public class HotelReservationService {
    private List<Hotel> hotels = new ArrayList<>();

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

  
    
    private int calculateTotalCost(Hotel hotel, List<LocalDate> dates, String customerType) {
        int total = 0;
        for (LocalDate date : dates) {
            boolean weekend = isWeekend(date);
            if (customerType.equalsIgnoreCase("Regular")) {
                total += weekend ? hotel.getRegularWeekendRate() : hotel.getRegularWeekdayRate();
            } else if (customerType.equalsIgnoreCase("Reward")) {
                total += weekend ? hotel.getRewardWeekendRate() : hotel.getRewardWeekdayRate();
            }
        }
        return total;
    }
     
    public Hotel findBestRatedHotel() {
        return hotels.stream()
                .max(Comparator.comparingInt(Hotel::getRating))
                .orElse(null);
    }
    
    
    // UC9: Cheapest hotel based on customer type
    public Hotel findCheapestHotel(String customerType, String... dates) {
        List<LocalDate> parsedDates = parseDates(dates);

        return hotels.stream()
                .min(Comparator
                        .comparingInt((Hotel h) -> calculateTotalCost(h, parsedDates, customerType))
                        .thenComparing(Hotel::getRating, Comparator.reverseOrder()))
                .orElse(null);
    }
    
    // UC10 - Find Best Rated Hotel For Reward Customers
    public Hotel findBestRatedHotelForRewardCustomer(String... dates) {
    	List<LocalDate> parsedDates = parseDates(dates);
    	
    	return hotels.stream()
    			.max(Comparator.comparingInt(Hotel::getRating))
    			.orElse(null);
    }
    
}
