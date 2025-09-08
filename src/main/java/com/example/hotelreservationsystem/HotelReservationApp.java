package com.example.hotelreservationsystem;


import com.example.hotelreservationsystem.model.Hotel;
import com.example.hotelreservationsystem.service.HotelReservationService;

/**
 * UC1: Main application - Display welcome message and add hotels.
 */
public class HotelReservationApp {
    public static void main(String[] args) {
        System.out.println("Welcome to the Hotel Reservation System!");

        HotelReservationService service = new HotelReservationService();

        // Add hotels with Regular + Reward rates
        service.addHotel(new Hotel("Lakewood", 110, 90, 80, 80, 3));
        service.addHotel(new Hotel("Bridgewood", 160, 60, 110, 50, 4));
        service.addHotel(new Hotel("Ridgewood", 220, 150, 100, 40, 5));

        
        // Add hotels with Regular + Reward rates
        service.addHotel(new Hotel("Lakewood", 110, 90, 80, 80, 3));
        service.addHotel(new Hotel("Bridgewood", 160, 60, 110, 50, 4));
        service.addHotel(new Hotel("Ridgewood", 220, 150, 100, 40, 5));

        // UC12: Find cheapest best-rated hotel for Regular customer
        Hotel bestHotel = service.findCheapestBestRatedHotelForRegular("11Sep2020", "12Sep2020");
        int totalCost = service.getTotalCostForRegular(bestHotel, "11Sep2020", "12Sep2020");

        System.out.println("Cheapest Best Rated Hotel for Regular: " 
                + bestHotel.getName() + ", Rating: " + bestHotel.getRating() 
                + ", Total Rates: $" + totalCost);
    }
}

