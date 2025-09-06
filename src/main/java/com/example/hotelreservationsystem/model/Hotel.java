package com.example.hotelreservationsystem.model;

/**
 * UC1: Hotel with name and weekday rate (for Regular customers).
 */
public class Hotel {
    private String name;
    private int weekdayRate;

    public Hotel(String name, int weekdayRate) {
        this.name = name;
        this.weekdayRate = weekdayRate;
    }

    public String getName() {
        return name;
    }

    public int getWeekdayRate() {
        return weekdayRate;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "name='" + name + '\'' +
                ", weekdayRate=" + weekdayRate +
                '}';
    }
}
