package com.example.hotelreservationsystem;

/**
 * Hello world!
 *
 */
import com.example.hotelreservationsystem.model.Hotel;
import com.example.hotelreservationsystem.service.HotelReservationService;

/**
 * UC1: Main application - Display welcome message and add hotels.
 */
public class HotelReservationApp {
    public static void main(String[] args) {
        System.out.println("Welcome to the Hotel Reservation System!");

        HotelReservationService service = new HotelReservationService();

        // Adding sample hotels (UC1)
        service.addHotel(new Hotel("Lakewood", 110));
        service.addHotel(new Hotel("Bridgewood", 160));
        service.addHotel(new Hotel("Ridgewood", 220));

        // Print added hotels
        System.out.println("Hotels added:");
        service.getHotels().forEach(System.out::println);
        
     // UC2: Find cheapest hotel for given dates
        Hotel cheapest = service.findCheapestHotel("10Sep2023", "11Sep2023");

        System.out.println("Cheapest Hotel: " + cheapest);
        
     // Find cheapest hotel (UC3) – sample dates
        Hotel cheapest1 = service.findCheapestHotel("10Sep2023", "11Sep2023", "12Sep2023");
        System.out.println("Cheapest Hotel: " + cheapest1);
        
        HotelReservationService service1 = new HotelReservationService();

        // UC4: Adding hotels
        service1.addHotel(new Hotel("Lakewood", 110, 90));
        service1.addHotel(new Hotel("Bridgewood", 160, 60));
        service1.addHotel(new Hotel("Ridgewood", 220, 150));

        // Print hotels
        System.out.println("Hotels added:");
        service.getHotels().forEach(System.out::println);

        // UC4: Cheapest hotel considering weekdays + weekends
        Hotel cheapest2 = service.findCheapestHotel("09Sep2023", "10Sep2023", "11Sep2023"); // Sat, Sun, Mon
        System.out.println("Cheapest Hotel: " + cheapest2.getName());
    
        
        HotelReservationService service2 = new HotelReservationService();

        // UC5: Adding hotels with ratings
        service2.addHotel(new Hotel("Lakewood", 110, 90, 3));
        service2.addHotel(new Hotel("Bridgewood", 160, 60, 4));
        service2.addHotel(new Hotel("Ridgewood", 220, 150, 5));

        System.out.println("Hotels with Ratings:");
        service.getHotels().forEach(System.out::println);

        // Find cheapest (price only, rating used later in UC6)
        Hotel cheapest3 = service.findCheapestHotel("09Sep2023", "10Sep2023", "11Sep2023");
        System.out.println("Cheapest Hotel: " + cheapest.getName() + " (Rating: " + cheapest.getRating() + ")");
    }
}

