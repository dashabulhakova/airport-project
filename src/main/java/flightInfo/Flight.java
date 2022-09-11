package flightInfo;

import enums.AirLine;

import java.util.Random;
import java.util.Scanner;

import org.apache.log4j.Logger;

public class Flight implements ICalculateCost, IBookASeat {
    private String flightNum;
    private int ticketNum ;
    private String seat;
    public Route route;
    public AirLine airline;
    double cost = 0;
    int filled = 0;
    protected static final Logger LOGGER = Logger.getLogger(Flight.class.getName());
    public Flight (String flightNum, int ticketNum, String seat, Route route) {
        this.flightNum = flightNum;
        this.ticketNum = ticketNum;
        this.seat = seat;
        this.route = route;
    }
    public Flight () {}

    @Override
    public void bookSeat(){

            char[][] seats = new char[7][4];
            for (int i = 0; i < 7; i++) {
                seats[i][0] = 'A';
                seats[i][1] = 'B';
                seats[i][2] = 'C';
                seats[i][3] = 'D';
            }

            String q = " ";
            System.out.println("Please enter the seat (e.g.- 1A) you wish to reserve.");
            printAvailableSeats(seats);
            Scanner keyboard = new Scanner(System.in);
            seat = keyboard.nextLine();
            if (seat.equals("e")) {
                return;
            }
            // print seating pattern and put an X in the seatNumber location
            while (filled < 28 && seat.length() > 0) {
                int row = seat.charAt(0) - '1';
                int col = seat.charAt(1) - 'A';
                if (row < 0 || row > 7 || col < 0 || col > 4) {
                    System.out.println("Input error. Enter seat to assign (e.g., '1A')," + "or q to quit.");
                    seat = keyboard.nextLine();
                    if (seat.equals("q")) {
                        return;
                    }
                } else {
                    if (seats[row][col] != 'X') {
                        seats[row][col] = 'X';
                        filled++;
                        System.out.println(" ");
                        printAvailableSeats(seats);
                    }
                    if (filled < 28) {
                        System.out.println("Enter seat to assign (e.g., '1A')," + "or q to quit.");
                        seat = keyboard.nextLine();
                        if (seat.equals("q")) {
                            return;
                        }
                    }
                }
            }
        }
        @Override
    public void printAvailableSeats(char[][] seats) {
        System.out.println("Row");
        for (int i = 0; i < seats.length; i++) {
            System.out
                    .println((i + 1) + "  " + seats[i][0] + " " + seats[i][1] + "  " + seats[i][2] + " " + seats[i][3]);

        }
        int numberOfSeatsAvailable = (28 - filled);
        System.out.println("There are " + numberOfSeatsAvailable + " seats available.");
    }
    public void createTicketNumber() throws NullPointerException{
        ticketNum = new Random(10).nextInt();

    }
    @Override
    public double flightCost() {
        //takes Airline's fare as a base price
        Scanner s = new Scanner(System.in);
        LOGGER.info("Please enter the Airline you are flying with: ");
        for (AirLine airlines : AirLine.values()) {
            LOGGER.info(airlines.getIndex() + " " + airlines.getName());
        }
        airline = AirLine.values()[Integer.parseInt(s.nextLine())];
        cost = airline.getFare();
        return cost;
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

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
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

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
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


