package flightInfo;
import enums.City;
import exceptions.InvalidDataException;
public class Route {
    private City origin;
    private City destination;
    public City city;
    private static boolean connecting = false;
    public Route() {

    }
    public Route(City origin, City destination) {
        this.origin = origin;
        this.destination = destination;
    }
    static class withConnection{
        public static void connect() {
            connecting = true;
        }
    }

    public City getOrigin() {
        return origin;
    }

    public void setOrigin(City origin) {
        this.origin = origin;
    }

    public City getDestination() {
        return destination;
    }

    public void setDestination(City destination) {
        this.destination = destination;
    }

}
