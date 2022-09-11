package utils;

import java.util.ArrayList;

import enums.City;
import flightInfo.Flight;
import flightInfo.Route;
import luggage.Bag;
import people.Passenger;

public class DataLoader {

    public static ArrayList<Flight> flights = new ArrayList<>();
    public static ArrayList<Route> routes = new ArrayList<>();
    public static ArrayList<Passenger> passengers = new ArrayList<>();
    public static ArrayList<Bag> bags = new ArrayList<>();

    public DataLoader() {}

    public static void loadData() {
        loadRoutes();
        loadBags();
        loadPassengers();
        loadFlights();
    }

    private static void loadRoutes() {
        routes.add(new Route(City.CITY1, City.CITY4));
        routes.add(new Route(City.CITY2, City.CITY3));
        routes.add(new Route(City.CITY3, City.CITY4));
    }

    private static void loadBags() {
        bags.add(new Bag(20, 5));
        bags.add(new Bag(20, 7));
        bags.add(new Bag(10, 30));
    }

    private static void loadPassengers() {
        passengers.add(new Passenger("FN1", "LN1", 123, 0, bags.get(0)));
        passengers.add(new Passenger("FN2", "LN2", 456, 2, bags.get(1)));
        passengers.add(new Passenger("FN3", "LN3", 789, 1, bags.get(2)));
    }

    private static void loadFlights() {
        flights.add(new Flight( "UA011022", 2,"1B", routes.get(0)));
        flights.add(new Flight( "UA012345", 1, "3A", routes.get(1)));
        flights.add(new Flight( "UA06789", 6, "6C", routes.get(1)));
    }
    public static ArrayList<Flight> getFlights() {
        return flights;
    }

    public static ArrayList<Route> getRoutes() {
        return routes;
    }

    public static ArrayList<Passenger> getPassengers() {
        return passengers;
    }

    public static ArrayList<Bag> getBags() {
        return bags;
    }

}

