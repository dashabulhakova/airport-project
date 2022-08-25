package enums;

import java.util.Scanner;

//this enum prints base fare associated with each airline, or it can print discounted fare(10%, 15%, and 20%)
public enum AirLine {
    DELTA(1, "Delta",176),
    SPIRIT(2, "Spirit",98),
    HAWAIIAN(3, "Hawaiian",250),
    UNITED_AIRLINES(4, "United Airlines",150),
    SOUTHWEST(5, "Southwest",275),
    FRONTIER(6, "Frontier",167),
    AMERICAN_AIRLINES(7, "American Airlines",138);

    private final int index;
    private final String name;
    private final double fare;
    AirLine(int index, String name, double fare) {
        this.index = index;
        this.name = name;
        this.fare = fare;
    }
    private double fare() {return fare; }

    public double getDiscountedFare(double discount){
        return fare - ((fare * discount) / 100);
    }

    public int getIndex() {
        return index;
    }

    public String getName() {
        return name;
    }

    public double getFare() {
        return fare;
    }
}
