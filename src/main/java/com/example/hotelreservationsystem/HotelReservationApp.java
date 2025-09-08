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
           
        HotelReservationService service1 = new HotelReservationService();

        // UC4: Adding hotels
        service1.addHotel(new Hotel("Lakewood", 110, 90));
        service1.addHotel(new Hotel("Bridgewood", 160, 60));
        service1.addHotel(new Hotel("Ridgewood", 220, 150));

        // Print hotels
        System.out.println("Hotels added:");
        service.getHotels().forEach(System.out::println);    
        
        HotelReservationService service2 = new HotelReservationService();

        // UC5: Adding hotels with ratings
        service2.addHotel(new Hotel("Lakewood", 110, 90, 3));
        service2.addHotel(new Hotel("Bridgewood", 160, 60, 4));
        service2.addHotel(new Hotel("Ridgewood", 220, 150, 5));

        System.out.println("Hotels with Ratings:");
        service.getHotels().forEach(System.out::println);

        // UC6: Find cheapest, break ties using rating
        Hotel bestCheapest = service.findCheapestBestRatedHotel("09Sep2023", "10Sep2023", "11Sep2023");
        System.out.println("Best Cheapest Hotel: " + bestCheapest.getName() +
                " | Rating: " + bestCheapest.getRating());
        
     // UC7: Find best-rated hotel
        Hotel bestRated = service.findBestRatedHotel();
        System.out.println("Best Rated Hotel: " + bestRated.getName() +
                " | Rating: " + bestRated.getRating());
     // UC8: Cheapest Best Rated Hotel
        Hotel cheapestBest = service.findCheapestBestRatedHotel("09Sep2023", "10Sep2023", "11Sep2023");
        System.out.println("Cheapest Best Rated Hotel: " + cheapestBest.getName() +
                " | Rating: " + cheapestBest.getRating());
    }
}

