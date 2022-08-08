package flightInfo;

    public class ConnectingIFlight implements IFlightOption {
    private int waitTime;
    private String location;
//implementing
    @Override
    public void changedWaitTime(int newWaitTime) {
        waitTime = newWaitTime;
    }
    public ConnectingIFlight(int waitTime, String location) {
        this.waitTime = waitTime;
        this.location = location;
    }

    @Override
    public String toString() {
        return "ConnectingFlight{" +
                "location='" + location + '\'' +
                '}';
    }
}

