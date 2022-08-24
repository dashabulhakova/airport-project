import java.util.*;

import enums.AirLine;
import enums.Meal;
import enums.MemberCard;
import exceptions.ExceedLimitException;
import exceptions.InvalidDataException;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import flightInfo.Flight;
import luggage.BagCheck;
import people.Passenger;
import utils.DataLoader;

import java.util.function.Predicate;

public class Main {
    protected static final Logger LOGGER = Logger.getLogger(Main.class.getName());
    private static ArrayList<Passenger> passengers = new ArrayList<Passenger>();
    private static int tickets = 0;
    public static void main(String[] ars) throws InvalidDataException, ExceedLimitException {

        Scanner scan = new Scanner(System.in);
        DataLoader.loadData();
        LOGGER.info(AirLine.SPIRIT.fare);
        Predicate<Passenger> allPassengers = passenger -> passenger.getFrequentFlyerNum() > 1;

        //applyDiscounts();
        //LOGGER.info("How much is you discount");
       // double calcPer = AirLine.AMERICAN_AIRLINES.getDiscountedFare(Double.parseDouble(scan.nextLine()));
       // LOGGER.info(calcPer);

        while (true) {
            LOGGER.info("Enter 1 to Register");
            LOGGER.info("Enter 2 to Display available flights");
            LOGGER.info("Enter 3 to Print All Passengers");
            LOGGER.info("Enter 4 to Choose a Meal");
            LOGGER.info("Enter 5 to Exit");
            int input = Integer.parseInt(scan.nextLine());
            switch (input) {
                case 1:
                    userRegistration();
                    break;
                case 2:
                    displayFlights();
                    break;
                case 3:
                    printAllPassengers();
                    break;
                case 4:

                    //checkMeasurements();
                    break;
                case 5:
                    LOGGER.info("Exiting...");
                    return;
                default:
                    LOGGER.info("You entered an invalid option");
                    break;
            }
        }
    }

    public static void displayFlights() {
        int size, seats;
        String o = "";
        String d = "";
        boolean same = false;

        Scanner s = new Scanner(System.in);
        size = DataLoader.getRoutes().size();

        for (int i = 0; i < size; i++) {
            Flight f = DataLoader.getFlights().get(i);
            o = f.getRoute().getOrigin();
            d = f.getRoute().getDestination();
            seats = f.getSeat();
            LOGGER.info("Search for tickets from");
            String origin = s.nextLine();
            String destination = s.nextLine();
            if ((o.equals(origin)) && d.equals(destination)) {
                if (same == false) {
                    LOGGER.info("Display available flights");
                    same = true;
                }
                DataLoader.getFlights().forEach(flight -> {
                    LOGGER.info(flight);
                });
                LOGGER.info(DataLoader.getFlights());
            }
        }
        if (same == false) {
            LOGGER.info("No flights available");
        }
    }

    public static void printAllPassengers() {
        passengers.forEach(passenger -> {
            LOGGER.info(passenger);
        });
    }

    public static void userRegistration() throws InvalidDataException {
        Scanner s = new Scanner(System.in);
        LOGGER.info("Please enter first name:");
        String firstName = s.nextLine();
        LOGGER.info("Please enter last name:");
        String lastName = s.nextLine();
        Passenger passenger = new Passenger(firstName, lastName);
        LOGGER.info("Please enter ticket number:");
        passenger.setTicketNum(Integer.parseInt(s.nextLine()));
        LOGGER.info("Please enter frequent flight member number:");
        passenger.setFrequentFlyerNum(Integer.parseInt(s.nextLine()));
        BagCheck b = new BagCheck();
        try {
            b.bagCheckIn();
        } catch (InvalidDataException e) {
            LOGGER.error("Error: " + e);
        }
        passenger.bag = b;
        passenger.setMeal(foodOption());
        LOGGER.info("Booking your ticket...");
        passengers.add(passenger);
        tickets++;
        try {
          createTicket(passenger);
        } catch (IOException e) {
            LOGGER.error("Error: " + e);
        }
        //LOGGER.info(tickets);
    }
    public static Meal foodOption() {
        Scanner s = new Scanner(System.in);
        LOGGER.info("Choose your meal: ");
        for (Meal meal : Meal.values()) {
            LOGGER.info(meal.option + " " + meal.mealType);
        }
        LOGGER.info("Enter your food choice");
                Meal meal = Meal.values()[Integer.parseInt(s.nextLine())];
                return meal;
    }
    public static void checkMeasurements() throws ExceedLimitException {
        double l = 0;
        double h = 0;
        double w = 0;
        Scanner s = new Scanner(System.in);
        BagCheck b = new BagCheck();
        try {
            LOGGER.info("Please check your bag's measurements in order: length, width, height");
            l = Double.parseDouble(s.nextLine());
            w = Double.parseDouble(s.nextLine());
            h = Double.parseDouble(s.nextLine());
            b.validateSize(l, w, h);
            //LOGGER.info("This one is in main" + BagCheck.Convert.CMTOINCHES.convert(l));
        } catch (ExceedLimitException e) {
            LOGGER.error("Error: " + e);
        }
    }
    public static void applyDiscounts(){
        MemberCard member; //what these r
        AirLine airline;
        double years;
        double ticketPrice;
        Scanner s = new Scanner(System.in);
        LOGGER.info("Please enter number of years as a member: ");
        years = Double.parseDouble(s.nextLine());
        if (years >= 1 && years <= 3) {
            LOGGER.info("Please enter ticket price:");
            double price = MemberCard.BRONZE.discountedMembership(Double.parseDouble(s.nextLine()));
            LOGGER.info("Your membership level is " + MemberCard.BRONZE.level + " and your discounted price is " + price);
        } else if (years >= 3 && years <=5) {
            member = MemberCard.SILVER;
        } else {
            member = MemberCard.GOLD;
        }
        //MemberCard member = MemberCard.values()[Integer.parseInt(s.nextLine())];
        //LOGGER.info("Your membership status is: " + member.level + " and your price with discount is: " + member.discountedMembership(Double.parseDouble(s.nextLine())));
    }
    public static void createTicket(Passenger passengers) throws IOException {
        if (tickets <= 0) {
            return;
        }
        File file = FileUtils.getFile("Tickets.txt");
        while (tickets > 0) {
            String newTicket = "\n-------------------------" + "" +
                    "\n|Ticket number: " + passengers.getTicketNum() +
                    "\n-------------------------" +
                    "\nPassenger name " + StringUtils.capitalize(passengers.firstName) +
                    " " + StringUtils.capitalize(passengers.lastName) +
                    "\nYou have: " +
                    passengers.bag + " bags" +
                    "\nSafe travels!";
            FileUtils.writeStringToFile(file, newTicket, "UTF-8", true);
            tickets--;
        }
        //FileUtils.write(new File("Tickets.txt"), "");
    }
}