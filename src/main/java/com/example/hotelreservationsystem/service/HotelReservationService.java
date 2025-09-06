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

  
    
 // UC3: Calculate total cost for a hotel
    private int calculateTotalCost(Hotel hotel, List<LocalDate> dates) {
        int total = 0;
        for (LocalDate date : dates) {
            if (isWeekend(date)) {
                total += hotel.getWeekendRate();
            } else {
                total += hotel.getWeekdayRate();
            }
        }
        return total;
    }
    
    
 // UC4: Find cheapest hotel considering weekday + weekend rates
    public Hotel findCheapestHotel(String... dates) {
        List<LocalDate> parsedDates = parseDates(dates);

        return hotels.stream()
                .min(Comparator.comparingInt(hotel -> calculateTotalCost(hotel, parsedDates)))
                .orElse(null);
    }
}
