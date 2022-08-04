package flightInfo;

public class Flight implements CalculateCost {
    private double cost;
    private String flightNum;
    private int flightTime;
    private int seat;
    public Route route;
    private static int flightCount;

    public Flight (double cost, String flightNum, int flightTime, int seat, Route route) {
        this.cost = cost;
        this.flightNum = flightNum;
        this.seat = seat;
        this.flightTime = flightTime;
        this.route = route;
        flightCount++;
    }
    public boolean bookSeat(){
        if (seat > 0) {
            seat = seat - 1;
            return true;
        }
        return false;
    }
       /* public int getInfo(){

        }*/

    @Override
    public void FlightCost() {
        if (flightTime > 5)
            cost = 300;
    }

    public static int getFlightCount() {
        return flightCount;
    }

    public double cost() {
        return cost;
    }
    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getCost() {
        return cost;
    }

    public int getFlightTime() {
        return flightTime;
    }

    public void setFlightTime(int flightTime) {
        this.flightTime = flightTime;
    }

    public String getFlightNum() {
        return flightNum;
    }

    public void setFlightNum(String flightNum) {
        this.flightNum = flightNum;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }
}


