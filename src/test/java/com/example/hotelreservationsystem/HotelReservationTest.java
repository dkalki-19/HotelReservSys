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
    public void givenHotels_WhenFindingBestRated_ShouldReturnHighestRatedHotel() {
        HotelReservationService service = new HotelReservationService();

        service.addHotel(new Hotel("Lakewood", 110, 90, 3));
        service.addHotel(new Hotel("Bridgewood", 160, 60, 4));
        service.addHotel(new Hotel("Ridgewood", 220, 150, 5)); // Highest rating

        Hotel result = service.findBestRatedHotel();

        assertEquals("Ridgewood", result.getName());
        assertEquals(5, result.getRating());
    }
    
    
    @Test
    public void givenRewardCustomer_WhenFindingCheapestBestRated_ShouldReturnRidgewood() {
        HotelReservationService service = new HotelReservationService();

        service.addHotel(new Hotel("Lakewood", 110, 90, 80, 80, 3));
        service.addHotel(new Hotel("Bridgewood", 160, 60, 110, 50, 4));
        service.addHotel(new Hotel("Ridgewood", 220, 150, 100, 40, 5));

        Hotel result = service.findCheapestBestRatedHotelForReward("11Sep2020", "12Sep2020");
        int totalCost = service.getTotalCost(result, "11Sep2020", "12Sep2020");

        assertEquals("Ridgewood", result.getName());
        assertEquals(5, result.getRating());
        assertEquals(140, totalCost); // 100 + 40
    }

    @Test
    public void givenRegularCustomer_WhenFindingCheapestBestRated_ShouldReturnBridgewood() {
        HotelReservationService service = new HotelReservationService();

        service.addHotel(new Hotel("Lakewood", 110, 90, 80, 80, 3));
        service.addHotel(new Hotel("Bridgewood", 160, 60, 110, 50, 4));
        service.addHotel(new Hotel("Ridgewood", 220, 150, 100, 40, 5));

        Hotel result = service.findCheapestBestRatedHotelForRegular("11Sep2020", "12Sep2020");
        int totalCost = service.getTotalCostForRegular(result, "11Sep2020", "12Sep2020");

        assertEquals("Bridgewood", result.getName());
        assertEquals(4, result.getRating());
        assertEquals(220, totalCost); // 160 (Fri) + 60 (Sat)
    }
   
   
}
