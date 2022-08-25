package people;
import java.util.Objects;

import enums.Meal;
import flightInfo.Flight;
import luggage.Bag;

public class Passenger extends Person {

    private int ticketNum;
    private int frequentFlyerNum;
    public Bag bag;
    public Meal meal;
    public Flight flight;
    public Passenger(String firstName, String lastName, int ticketNum, int frequentFlyerNum, Bag bag) {
        super(firstName, lastName);
        this.ticketNum = ticketNum;
        this.frequentFlyerNum = frequentFlyerNum;
        this.bag = bag;
    }
    public Passenger(String firsName, String lastName) {
        super(firsName, lastName);
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "ticketNum=" + ticketNum +
                ", frequentFlyerNum=" + frequentFlyerNum +
                ", bag=" + bag +
                ", meal=" + meal +
                ", flight=" + flight +
                '}';
    }

    @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Passenger)) return false;
            Passenger passenger = (Passenger) o;
            return ticketNum == passenger.ticketNum;
        }

        @Override
        public int hashCode() {
            return Objects.hash(ticketNum);
        }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Meal getMeal() {
        return meal;
    }

    public void setMeal(Meal meal) {
        this.meal = meal;
    }

    public Bag getBag() {
        return bag;
    }

    public void setBag(Bag bag) {
        this.bag = bag;
    }

    public int getTicketNum() {
        return ticketNum;
    }

    public void setTicketNum(int ticketNum) {
        this.ticketNum = ticketNum;
    }

    public int getFrequentFlyerNum() {
        return frequentFlyerNum;
    }

    public void setFrequentFlyerNum(int frequentFlyerNum) {
        this.frequentFlyerNum = frequentFlyerNum;
    }
}

