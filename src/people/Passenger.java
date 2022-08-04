package people;
import java.util.Objects;
import luggage.Bags;

public class Passenger extends Person{

        private int ticketNum;
        private int frequentFlyerNum;
        public Bags bags;

        public Passenger(String firstName, String lastName, int ticketNum, int frequentFlyerNum, Bags bags) {
            super(firstName, lastName);
            this.ticketNum = ticketNum;
            this.frequentFlyerNum = frequentFlyerNum;
            this.bags = bags;
        }

        // public checkBag(Bags bagCheckin) {

        // }
        @Override
        public String toString() {
            return "Passenger{" +
                    "workId=" + ticketNum +
                    ", firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
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
    }

