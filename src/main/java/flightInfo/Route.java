package flightInfo;
import exceptions.InvalidDataException;
public class Route {
    private String origin;
    private String destination;
    private static boolean connecting = false;
    public Route() {

    }
    public Route(String origin, String destination) {
        this.origin = origin;
        this.destination = destination;
    }
    static class withConnection{
        public static void connect() {
            connecting = true;
        }
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

}
