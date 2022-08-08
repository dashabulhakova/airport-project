import java.util.Scanner;
import flightInfo.Flight;
import flightInfo.Route;
//import org.apache.log4j.Logger;
public class Main {
    //static Logger logger = Logger.getLogger(Main.class);
    public static void main(String[] ars) {
        //create an instance of 'Route'
        Route route = new Route("Paris", "Miami" );
        //create an instance of 'Flight' and pass route as an argument
        Flight f = new Flight(200, "DF098", 4, 43, route);
        System.out.println("Flight number is " + f.getFlightNum());

        System.out.println("Number of available flights to New York: " + Flight.getFlightCount());
        Scanner s = new Scanner(System.in);
        System.out.println("Enter your flight");
        try {
            int n = s.nextInt();
            System.out.println(n);
        } catch(Exception e) {
            System.out.println("Please enter flight number");
        }
        //Bags b = new Bags(5, 78);
        //b.bagCheckin();
    }

}