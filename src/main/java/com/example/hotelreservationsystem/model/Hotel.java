package com.example.hotelreservationsystem.model;

/**
 * UC1: Hotel with name and weekday rate (for Regular customers).
 */
public class Hotel {
    private String name;
    private int weekdayRate;
    private int weekendRate;
    private int regularWeekdayRate;
    private int regularWeekendRate;
    private int rewardWeekdayRate;
    private int rewardWeekendRate;
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

    public Hotel(String name, int regularWeekdayRate, int regularWeekendRate,
            int rewardWeekdayRate, int rewardWeekendRate, int rating) {
	   this.name = name;
	   this.regularWeekdayRate = regularWeekdayRate;
	   this.regularWeekendRate = regularWeekendRate;
	   this.rewardWeekdayRate = rewardWeekdayRate;
	   this.rewardWeekendRate = rewardWeekendRate;
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
    
    public int getRegularWeekdayRate() {
        return regularWeekdayRate;
    }

    public int getRegularWeekendRate() {
        return regularWeekendRate;
    }

    public int getRewardWeekdayRate() {
        return rewardWeekdayRate;
    }

    public int getRewardWeekendRate() {
        return rewardWeekendRate;
    }
    
    public int getRating() { 
    	return rating; 
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "name='" + name + '\'' +
                ", regularWeekdayRate=" + regularWeekdayRate +
                ", regularWeekendRate=" + regularWeekendRate +
                ", rewardWeekdayRate=" + rewardWeekdayRate +
                ", rewardWeekendRate=" + rewardWeekendRate +
                ", rating=" + rating +
                '}';
    }
}
