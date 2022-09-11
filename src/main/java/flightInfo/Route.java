package flightInfo;
import enums.City;
import exceptions.InvalidDataException;
import org.apache.log4j.Logger;

public class Route {
    private City origin;
    private City destination;
    public City city;
    private static boolean connecting = false;
    public Route() {

    }
    protected static final Logger LOGGER = Logger.getLogger(Route.class.getName());
    public Route(City origin, City destination) {
        this.origin = origin;
        this.destination = destination;
    }
    static class withConnection{
        public static void connect() {
            connecting = true;
        }
    }
    public void validateRoute() throws InvalidDataException {
        if (this.origin == null || this.destination == null) {
            throw new InvalidDataException("You entered the wrong origin or destination");
        } else {
            LOGGER.info("Route is validated");
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
