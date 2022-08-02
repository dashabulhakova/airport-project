import java.util.Scanner;

public class Main {
    public static void main(String[] ars) {
        //create an instance of 'Route'
        Route route = new Route("Paris", "Miami" );
        //create an instance of 'Flight' and pass route as an argument
        Flight f = new Flight(200, "DF098", 4, 43, route);
        System.out.println("Flight will cost " + f.getCost() + "$, Flight number is " + f.getFlightNum());

        System.out.println("Number of available flights to New York: " + Flight.getFlightCount());

        Bags b = new Bags(5, 78);
        b.bagCheckin();
    }

}