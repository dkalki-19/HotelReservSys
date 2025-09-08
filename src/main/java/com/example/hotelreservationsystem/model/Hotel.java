package com.example.hotelreservationsystem.model;

/**
 * UC1: Hotel with name and weekday rate (for Regular customers).
 */
public class Hotel {
    private String name;
    private int weekdayRate;
    private int weekendRate;
    private int rating;

    public Hotel(String name, int weekdayRate) {
        this.name = name;
        this.weekdayRate = weekdayRate;    
    }

    public Hotel(String name, int weekdayRate, int weekendRate) {
        this.name = name;
        this.weekdayRate = weekdayRate;
        this.weekendRate = weekendRate;
    }
    
    public Hotel(String name, int weekdayRate, int weekendRate, int rating) {
        this.name = name;
        this.weekdayRate = weekdayRate;
        this.weekendRate = weekendRate;
        this.rating = rating; 
    }

    public String getName() {
        return name;
    }

    public int getWeekdayRate() {
        return weekdayRate;
    }
    
    public int getWeekendRate() {
        return weekendRate;
    }
    
    public int getRating() { 
    	return rating; 
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "name='" + name + '\'' +
                ", weekdayRate=" + weekdayRate +
                ", weekendRate=" + weekendRate +
                ", rating=" + rating +
                '}';
    }
}
