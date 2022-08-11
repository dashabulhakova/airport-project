package flightInfo;

public class Flight implements ICalculateCost {
    private double cost;
    private String flightNum;
    private int flightTime;
    private int seat;
    public Route route;
    private String section;
    private static int flightCount;

    public Flight (int cost, String flightNum, int flightTime, int seat, Route route) {
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
    public void flightCost() {
        if (section == "Economy") {
            if (flightTime < 5) {
                cost = 300;
            } else if (flightTime > 5) {
                cost = 500;
            }
        } else if (section == "Business class") {
                if (flightTime < 5) {
                    cost = 600;
                } else if (flightTime > 5) {
                    cost = 800;
                }
            }

    }

    public static int getFlightCount() {
        return flightCount;
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


