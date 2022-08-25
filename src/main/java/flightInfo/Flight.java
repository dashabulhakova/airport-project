package flightInfo;

import enums.AirLine;

import java.util.Random;
import java.util.Scanner;

import org.apache.log4j.Logger;

public class Flight implements ICalculateCost {
    private String flightNum;
    private int ticketNum ;
    private int seat;
    public Route route;
    public AirLine airline;
    protected static final Logger LOGGER = Logger.getLogger(Flight.class.getName());
    public Flight (String flightNum, int ticketNum, int seat, Route route) {
        this.flightNum = flightNum;
        this.ticketNum = ticketNum;
        this.seat = seat;
        this.route = route;
    }
    public Flight () {}

    public void bookSeat(){
        seat = new Random(10).nextInt();
    }

    public void createTicketNumber() throws NullPointerException{
        ticketNum = new Random(10).nextInt();

    }
    @Override
    public AirLine flightCost() {
        //takes Airline's fare as a base price
        Scanner s = new Scanner(System.in);
        LOGGER.info("Please enter the Airline you are flying with: ");
        for (AirLine airlines : AirLine.values()) {
            LOGGER.info(airlines.getIndex() + " " + airlines.getName());
        }
        airline = AirLine.values()[Integer.parseInt(s.nextLine())];
        airline.getFare();
        return airline;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "flightNum='" + flightNum + '\'' +
                ", flightTime=" + ticketNum +
                ", seat=" + seat +
                ", route=" + route +
                ", airline=" + airline +
                '}';
    }

    public int getTicketNum() {
        return ticketNum;
    }

    public void setTicketNum(int flightTime) {
        this.ticketNum = ticketNum;
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

    public AirLine airLine() {
        return airline;
    }

    public void setAirline(AirLine flightCost) {
        this.airline = flightCost;
    }
}


