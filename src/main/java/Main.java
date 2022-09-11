import java.util.*;

import enums.AirLine;
import enums.City;
import enums.Meal;
import enums.MemberCard;
import exceptions.ExceedLimitException;
import exceptions.InvalidDataException;
import flightInfo.Route;
import functionalInterface.*;
import luggage.Bag;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import flightInfo.Flight;
import luggage.BagCheck;
import people.Passenger;
import utils.DataLoader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class Main {
    protected static final Logger LOGGER = Logger.getLogger(Main.class.getName());
    private static ArrayList<Passenger> passengers = new ArrayList<Passenger>();
    private static int tickets = 0;
    public static void main(String[] ars) throws InvalidDataException, ExceedLimitException {

        Scanner scan = new Scanner(System.in);
        DataLoader.loadData();

        while (true) {
            LOGGER.info("Enter 1 to Register");
            LOGGER.info("Enter 2 to Test methods");
            LOGGER.info("Enter 3 to Print All Passengers");
            LOGGER.info("Enter 4 to Check the Measurements of your Bag");
            LOGGER.info("Enter 5 to Exit");
            int input = Integer.parseInt(scan.nextLine());
            switch (input) {
                case 1:
                    userRegistration();
                    break;
                case 2:
                    forLambda();
                    genericLambda();
                    deadLock();
                    break;
                case 3:
                    printAllPassengers();
                    break;
                case 4:
                    //checkMeasurements();
                    bag();
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

    public static void forLambda() {
        IAdd a = (x, y) -> x + y;
        LOGGER.info(a.add(1, 2));
    }
    public static void genericLambda(){
        IGenericInterface<Integer> factorial = (n) -> {

            int result = 1;
            for (int i = 1; i <= n; i++)
                result = i * result;
            return result;
        };

        System.out.println("factorial of 5 = " + factorial.func(5));
    }
    public static void piInterface() {

        ICalcualtePi p = () -> 3.1415;
        LOGGER.info("Value of Pi = " + p.getPi());
    }

    public static void stringInterface() {
        IReverseString rev = (str) -> {

            String result = "";
            for (int i = str.length()-1; i >= 0 ; i--)
                result += str.charAt(i);
            return result;
        };

        LOGGER.info("Lambda reversed = " + rev.reverse("Lambda"));
    }
    public static void stringAddInt() {
        IConcatString s = (str1, str2) -> str1 + str2;
        LOGGER.info("Result: "+s.sconcat("My ", "string"));
    }

    public static void deadLock() {
        NewThread lock1 = new NewThread();
        NewRunnable lock2 = new NewRunnable();
        Thread thread1 = new Thread();
        LOGGER.info("Thread " + Thread.currentThread().getName() + " starts here");
        synchronized(lock1) {
            LOGGER.info("Thread 1: Holding lock 1...");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {}
            LOGGER.info("Thread 1: Waiting for lock 2...");
            }
        synchronized (lock2) {
            LOGGER.info("Thread 1: Holding lock 1 & 2...");
        }
        Thread thread2 = new Thread();
        LOGGER.info("Thread " + thread2.getName() + " starts here");
        synchronized (lock1) {
            LOGGER.info("Thread 2: Holding lock 1...");

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {}
            LOGGER.info("Thread 2: Waiting for lock 2...");

            synchronized (lock2) {
                LOGGER.info("Thread 2: Holding lock 1 & 2...");
            }
        }
        thread1.start();
        thread2.start();
    }
    public static void printAllPassengers() {
            LOGGER.info(passengers);
            //(passenger -> {
            //            LOGGER.info(passenger);
    }

    public static void userRegistration() throws InvalidDataException, NullPointerException {
        Scanner s = new Scanner(System.in);

        Route route = new Route();
        Flight flight = new Flight();
        flight.bookSeat();
        flight.createTicketNumber();

        LOGGER.info("Enter origin");
        String origin = s.nextLine();
        LOGGER.info("Enter destination");
        String destination = s.nextLine();
        for (City city : City.values()) {
            if (origin.equalsIgnoreCase(city.getName())) {
                   route.setOrigin(city);
                    LOGGER.info("There is a route found for you");
            } else if (destination.equalsIgnoreCase(city.getName())){
                    route.setDestination(city);
            }
        }
            route.validateRoute();

        LOGGER.info("Please enter first name:");
        String firstName = s.nextLine();
        LOGGER.info("Please enter last name:");
        String lastName = s.nextLine();
        Passenger passenger = new Passenger(firstName, lastName);
        applyDiscounts();

        BagCheck b = new BagCheck();
        try {
            b.bagCheckIn();
        } catch (InvalidDataException e) {
            LOGGER.error("Error: " + e);
        }
        passenger.bag = b;
        passenger.setMeal(foodOption());
        flight.createTicketNumber();
        LOGGER.info("Booking your ticket...");
        passenger.setFlight(flight);
        passengers.add(passenger);
        tickets++;
        try {
          createTicket(passenger);
        } catch (IOException e) {
            LOGGER.error("Error: " + e);
        }
    }
    public static Meal foodOption() {
        Scanner s = new Scanner(System.in);
        LOGGER.info("Choose your meal: ");
        for (Meal meal : Meal.values()) {
            LOGGER.info(meal.getOption() + " " + meal.getMealType());
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
        } catch (ExceedLimitException e) {
            LOGGER.error("Error: " + e);
        }

        //reflection
       // Bag bag = new Bag();

    }
    public static void bag() {
        int s = 0;
        int w = 0;
        Scanner scan = new Scanner(System.in);
        LOGGER.info("Please enter weight and size of your bag");
        w = Integer.parseInt(scan.nextLine());
        s = Integer.parseInt(scan.nextLine());
        try {
            Bag bag = new Bag();
            bag = Bag.class.getConstructor(int.class, int.class).newInstance(s, w);
            Method getBagDetails = Bag.class.getMethod("checkBagWeight", int.class, int.class);
            int weight = (int) getBagDetails.invoke(bag,s, w);
            LOGGER.info("The weight of your bag is " + weight);

        } catch (InvocationTargetException | InstantiationException | IllegalAccessException
                 | NoSuchMethodException e) {
            throw new RuntimeException(e);
            //LOGGER.error("Error: " + e);
        }
    }
    public static void applyDiscounts(){
        MemberCard member;
        AirLine airline;
        double years;
        double basePrice;
        double ticketPrice;
        Flight flight = new Flight();
        Scanner s = new Scanner(System.in);
        LOGGER.info("Please enter number of years as a member: ");
        years = Double.parseDouble(s.nextLine());
        flight.flightCost();
        if (years >= 1 && years <= 3) {
            ticketPrice = MemberCard.BRONZE.discountedMembership(flight.airline.getFare());
            LOGGER.info("Your membership level is " + MemberCard.BRONZE.getLevel() + " and your discounted price is " + ticketPrice);
        } else if (years >= 3 && years <=5) {
            ticketPrice = MemberCard.SILVER.discountedMembership(flight.airline.getFare());
            LOGGER.info("Your membership level is " + MemberCard.SILVER.getLevel() + " and your discounted price is " + ticketPrice);
        } else {
            ticketPrice = MemberCard.GOLD.discountedMembership(flight.airline.getFare());
            LOGGER.info("Your membership level is " + MemberCard.GOLD.getLevel() + " and your discounted price is " + ticketPrice);
        }
        flight.setCost(ticketPrice);
    }
    public static void createTicket(Passenger passengers) throws IOException {
        Flight flight = new Flight();
        if (tickets <= 0) {
            return;
        }
        File file = FileUtils.getFile("Tickets.txt");
        while (tickets > 0) {
            String newTicket = "\n-------------------------" + "" +
                    "\n|Ticket number: " + passengers.flight.getTicketNum() +
                    "\n-------------------------" +
                    "\nTicket for " + StringUtils.capitalize(passengers.firstName) +
                    " " + StringUtils.capitalize(passengers.lastName) +
                    "                  " +
                    "seat number " + passengers.flight.getSeat() +
                    "\nYou have: " +
                    passengers.bag + " checked bags" +
                    "\nYou have chosen a " + passengers.getMeal().getMealType() + " meal" +
                    "\nAmount to pay: "  + passengers.flight.getCost() +
                    "\nSafe travels!";
            FileUtils.writeStringToFile(file, newTicket, "UTF-8", true);
            tickets--;
        }
        //FileUtils.write(new File("Tickets.txt"), "");
    }
}