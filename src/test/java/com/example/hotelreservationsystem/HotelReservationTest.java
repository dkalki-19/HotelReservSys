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
    public void givenDateRange_ShouldReturnCheapestHotel() {
        HotelReservationService service = new HotelReservationService();
        service.addHotel(new Hotel("Lakewood", 110));
        service.addHotel(new Hotel("Bridgewood", 160));
        service.addHotel(new Hotel("Ridgewood", 220));

        Hotel cheapest = service.findCheapestHotel("10Sep2023", "11Sep2023");

        assertEquals("Lakewood", cheapest.getName());
    }
    
    @Test
    public void givenHotels_WhenFindCheapestConsideringWeekend_ShouldReturnCorrectHotel() {
        HotelReservationService service = new HotelReservationService();
        service.addHotel(new Hotel("Lakewood", 110, 90));
        service.addHotel(new Hotel("Bridgewood", 160, 60));
        service.addHotel(new Hotel("Ridgewood", 220, 150));

        // Weekend included: 9Sep (Sat), 10Sep (Sun), 11Sep (Mon)
        Hotel cheapest = service.findCheapestHotel("09Sep2023", "10Sep2023", "11Sep2023");

        assertEquals("Bridgewood", cheapest.getName());
    }
    
}
