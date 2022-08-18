import java.util.Arrays;
import java.util.Scanner;

import exceptions.InvalidDataException;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

import flightInfo.Flight;
import flightInfo.Route;
import luggage.BagCheck;
import people.Passenger;
import utils.DataLoader;
import java.util.HashSet;
import java.util.Arrays;
public class Main {
    protected static final Logger LOGGER = Logger.getLogger(Main.class.getName());
    public static void main(String[] ars) throws IOException{

        File filename = new File("src/main/java/utils/text.txt");
        //Construct a file from the set of filename elements.
        File file = FileUtils.getFile(filename);
        //read a file to a string
        String fileText = StringUtils.lowerCase(FileUtils.readFileToString(file, "UTF-8"));
        fileText = fileText.replaceAll("[^a-zA-Z \n]","");
        LOGGER.info(fileText);
        //split contents of a string into array and store in a hashset
        HashSet<String> uniqueWords = new HashSet<String>(Arrays.asList(fileText.split("\\s")));
        uniqueWords.remove("");
        LOGGER.info(uniqueWords);
        FileUtils.writeStringToFile(file, "\n\nCurrent number of unique words in this file: " + uniqueWords.size(), "UTF-8", true);
        LOGGER.info("Currently " + uniqueWords.size() + " unique words in file " + file.getName());
        LOGGER.info(uniqueWords);
        //return fileText.length();

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
        BagCheck b = new BagCheck();
        while(flag != true) {
            try {
                b.bagCheckIn();
            } catch (InvalidDataException e) {}

            LOGGER.info("Enter 1 to Register");
            LOGGER.info("Enter 2 to Display available flights");
           // System.out.println("Enter 3 to get information about your flight"); include food, seats etc
            //System.out.println("Enter 4 to book a seat");
            LOGGER.info("Enter 5 to Exit");
            input = scan.nextInt();
            switch (input) {
                case 1:
                    userRegistration();
                        while (flag2 != true) {
                            LOGGER.info("Enter 1 to Book a Ticket");
                            LOGGER.info("Enter 2 to Check your Membership Status");
                            LOGGER.info("Enter 3 to Choose a Meal");
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
                    LOGGER.info("Exiting...");
                    break;
                default:
                    LOGGER.info("You entered an invalid option");
                    break;
            }
        }
        /*
        Route route = new Route("Paris", "Miami" );
        Flight f = DataLoader.getFlights().get(0);
        LOGGER.info("This is destination" + f.getRoute().getDestination());
                //new Flight(200, "DF098", 4, 43, route);
        LOGGER.info("Flight number is " + f.getFlightNum());

        LOGGER.info("Number of available flights to New York: " + Flight.getFlightCount());

        LOGGER.info("Enter your flight" + f.getRoute().getOrigin());
        */
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
            LOGGER.info("Search for tickets from");
            String origin = s.nextLine();
            String destination = s.nextLine();
            if((o.equals(origin)) && d.equals(destination)) {
            if (same == false) {
                LOGGER.info("Display available flights");
                same = true;
            }
                LOGGER.info(DataLoader.getFlights());
            }
        }
        if (same == false) {
            LOGGER.info("No flights available");
        }
    }
    public static void userRegistration() {
        Scanner s = new Scanner(System.in);
        BagCheck b = new BagCheck();

        LOGGER.info("Please enter name:");
        String name = s.nextLine();
        LOGGER.info("Please enter ticket number:");
        Integer ticketNum = s.nextInt();
        LOGGER.info("Please enter outbound location:");
        String origin = s.nextLine();
        LOGGER.info("Please enter preferred destination:");
        String destination = s.nextLine();
        LOGGER.info("Do you have any bags to check in?");
        b.bagPresent();
        //ask about connecting flight
        LOGGER.info("Booking your ticket...");
    }
}