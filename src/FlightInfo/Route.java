package FlightInfo;

public class Route {
    private String origin;
    private String destination;

    private static boolean connecting = false;
    public Route(String origin, String destination) {
        this.origin = origin;
        this.destination = destination;
    }
    static class withConnection{
        public static void connect() {
            connecting = true;
        }
    }
}
