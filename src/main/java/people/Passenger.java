package people;
import java.util.Objects;
import luggage.Bag;

public class Passenger extends Person implements ICheckMembership {

        private int ticketNum;
        private int frequentFlyerNum;
        public Bag bag;

        public Passenger(String firstName, String lastName, int ticketNum, int frequentFlyerNum, Bag bag) {
            super(firstName, lastName);
            this.ticketNum = ticketNum;
            this.frequentFlyerNum = frequentFlyerNum;
            this.bag = bag;
        }
        public int calculateDiscount(int discount) {
        if (frequentFlyerNum <= 1 && frequentFlyerNum <= 100 ) {
            discount = 10;
            System.out.print("Your discount is 10 percent");
        } else if (frequentFlyerNum < 100 && frequentFlyerNum <=200) {
            discount = 20;
            System.out.print("Your discount is 10 percent");
        }
        return discount;
        }
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

