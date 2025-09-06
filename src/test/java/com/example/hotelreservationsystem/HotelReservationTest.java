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
}
