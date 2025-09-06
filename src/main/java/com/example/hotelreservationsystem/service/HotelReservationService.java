package com.example.hotelreservationsystem.service;



import com.example.hotelreservationsystem.model.Hotel;
import java.util.ArrayList;
import java.util.List;

/**
 * UC1: Service class to add hotels and list them.
 */
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
}
