package enums;

import java.util.Scanner;

//this enum prints base fare associated with each airline, or it can print discounted fare(10%, 15%, and 20%)
public enum AirLine {
    DELTA(176),
    SPIRIT(98),
    HAWAIIAN(250),
    UNITED_AIRLINES(150),
    SOUTHWEST(275),
    FRONTIER(167),
    AMERICAN_AIRLINES(138);


    public final double fare;
    AirLine(double fare) {
        this.fare = fare;
    }
    private double fare() {return fare; }

    public double getDiscountedFare(double discount){
        return fare - ((fare * discount) / 100);
    }

    public double getFare() {
        return fare;
    }
}
