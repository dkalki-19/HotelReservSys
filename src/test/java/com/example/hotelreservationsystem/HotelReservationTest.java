package com.example.hotelreservationsystem;


import com.example.hotelreservationsystem.model.Hotel;
import com.example.hotelreservationsystem.service.HotelReservationService;

import org.junit.Test;
import static org.junit.Assert.*;

public class HotelReservationTest {

    @Test
    public void givenHotel_WhenAdded_ShouldBeInList() {
        HotelReservationService service = new HotelReservationService();
        Hotel hotel = new Hotel("Lakewood", 110);

        service.addHotel(hotel);

        assertEquals(1, service.getHotels().size());
        assertEquals("Lakewood", service.getHotels().get(0).getName());
        assertEquals(110, service.getHotels().get(0).getWeekdayRate());
    }
   
    
    @Test
    public void givenHotels_WhenAddedWithRatings_ShouldStoreCorrectly() {
        HotelReservationService service = new HotelReservationService();
        service.addHotel(new Hotel("Lakewood", 110, 90, 3));
        service.addHotel(new Hotel("Bridgewood", 160, 60, 4));
        service.addHotel(new Hotel("Ridgewood", 220, 150, 5));

        assertEquals(3, service.getHotels().size());
        assertEquals("Ridgewood", service.getHotels().get(2).getName());
        assertEquals(5, service.getHotels().get(2).getRating());
    }
    
    
    @Test
    public void givenHotels_WhenCheapestTie_ShouldReturnHigherRatedHotel() {
        HotelReservationService service = new HotelReservationService();

        // Two hotels with same weekday/weekend total, but different ratings
        service.addHotel(new Hotel("Lakewood", 100, 50, 3));
        service.addHotel(new Hotel("Bridgewood", 100, 50, 4)); // Higher rating

        Hotel result = service.findCheapestBestRatedHotel("09Sep2023", "10Sep2023");

        assertEquals("Bridgewood", result.getName());
        assertEquals(4, result.getRating());
    }
}
