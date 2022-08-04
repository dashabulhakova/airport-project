package flightInfo;

    abstract class ConnectingFlight implements FlightOption {
    private int waitTime;
    private String location;
//implementing
    @Override
    public void changedWaitTime(int newWaitTime) {
        waitTime = newWaitTime;
    }
    public ConnectingFlight(int waitTime, String location) {
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

