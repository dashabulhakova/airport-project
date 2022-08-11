import java.util.Scanner;

import org.apache.log4j.Logger;

import flightInfo.Flight;
import flightInfo.Route;
import luggage.BagCheck;
import people.Passenger;
import utils.DataLoader;

public class Main {
    protected static final Logger LOGGER = Logger.getLogger(Main.class);
    public static void main(String[] ars) {

        Scanner scan = new Scanner(System.in);
        DataLoader.loadData();
        Passenger p = DataLoader.getPassengers().get(0);
        int input, choice = 0;
        boolean flag = false;
        boolean flag2 = false;

    LOGGER.info("Loader message");
    /*LOGGER.info("Please enter your name: ");
    String name = scan.nextLine();
    System.out.println("Name from logger" + p.getFirstName());
    */
        while(flag != true) {
            System.out.println("Enter 1 to Register");
            System.out.println("Enter 2 to Display available flights");
           // System.out.println("Enter 3 to get information about your flight"); include food, seats etc
            //System.out.println("Enter 4 to book a seat");
            System.out.println("Enter 5 to Exit");
            input = scan.nextInt();
            switch (input) {
                case 1:
                    userRegistration();
                        while (flag2 != true) {
                            System.out.println("Enter 1 to Book a Ticket");
                            System.out.println("Enter 2 to Check your Membership Status");
                            System.out.println("Enter 3 to Choose a Meal");
                            switch (choice) {
                                case 1:
                                case 2:
                                    LinkedList<Passenger> member = new LinkedList<>();
                            }
                        }
                            break;
                case 2:
                    displayFlights();
                    break;
                case 3:
                case 4:
                case 5:
                    flag = true;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("You entered an invalid option");
                    break;
            }
        }
        //create an instance of 'Route'
        Route route = new Route("Paris", "Miami" );
        //create an instance of 'Flight' and pass route as an argument
        Flight f = DataLoader.getFlights().get(0);
        System.out.println("This is destination" + f.getRoute().getDestination());
                //new Flight(200, "DF098", 4, 43, route);
        System.out.println("Flight number is " + f.getFlightNum());

        System.out.println("Number of available flights to New York: " + Flight.getFlightCount());

        System.out.println("Enter your flight" + f.getRoute().getOrigin());

        //Bags b = new Bags(5, 78);
        //b.bagCheckin();
    }
    public static void displayFlights() {
        int size, seats;
        String o = "";
        String d = "";
        boolean same = false;

        Scanner s = new Scanner(System.in);
        size = DataLoader.getRoutes().size();

        for (int i = 0; i <size; i++) {
            Flight f = DataLoader.getFlights().get(i);
            o = f.getRoute().getOrigin();
            d = f.getRoute().getDestination();
            seats = f.getSeat();
            System.out.println("Search for tickets from");
            String origin = s.nextLine();
            String destination = s.nextLine();
            if((o.equals(origin)) && d.equals(destination)) {
            if (same == false) {
                System.out.println("Display available flights");
                same = true;
            }
                System.out.println(DataLoader.getFlights());
            }
        }
        if (same == false) {
            System.out.println("No flights available");
        }
    }
    public static void userRegistration() {
        Scanner s = new Scanner(System.in);
        LOGGER.info("Please enter name:");
        String name = s.nextLine();
        LOGGER.info("Please enter ticket number:");
        Integer ticketNum = s.nextInt();
        LOGGER.info("Please enter outbound location:");
        String origin = s.nextLine();
        LOGGER.info("Please enter preferred destination:");
        String destination = s.nextLine();
        //ask about connecting flight
        System.out.println("Booking your ticket...");
    }
}