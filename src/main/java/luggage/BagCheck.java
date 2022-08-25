package luggage;
import java.util.Objects;
import java.util.Scanner;
import exceptions.ExceedLimitException;
import exceptions.InvalidDataException;
import org.apache.log4j.Logger;

public class BagCheck extends Bag implements ICalculateBags, IBagCheck {
    private int bagsTotal = 0;
    private boolean hasBag = false;
    //standard carry-on measurements
    private static final double length = 22;
    private static final double width = 14;
    private static final double height = 9;
    private static final Logger LOGGER = Logger.getLogger(BagCheck.class.getName());
    public enum Convert {
        CMTOINCHES(0.4);

        private final double cm;
        Convert(double cm) {
            this.cm = cm;
        }
        public double convert(double measurement) {
            return measurement * cm;
        }
    }
    public boolean bagPresent() {
        return hasBag;
    }
    public BagCheck () {

    };
    public BagCheck(int size, int weight, int bagsTotal) {
        super(size, weight);
        try {
            this.bagsTotal = bagsTotal;
            validateAmount(this.bagsTotal);
        } catch (Exception e) {
            System.out.println("Here:" + e);
        }
    }


   @Override
    public void validateAmount(int bagsTotal) throws ExceedLimitException {
        if (bagsTotal > 2) {
            throw new ExceedLimitException("You have too many bags to check in");
        }
    }

    @Override
    public void validateSize(double length, double width, double height) throws ExceedLimitException {
        double l = Convert.CMTOINCHES.convert(length);
        //LOGGER.info(l);
        double w = Convert.CMTOINCHES.convert(width);
        double h = Convert.CMTOINCHES.convert(height);
        if (l > this.length || w > this.width || h > this.height) {
            throw new ExceedLimitException("Your bag size exceeds limits");
        }
    }
@Override
    public int bagCheckIn() throws InvalidDataException {
        Scanner s = new Scanner(System.in);
        String decision;
        System.out.println("Do you have any bags to check in? yes/no");
        decision = s.nextLine();
        switch (decision) {
            case "yes":
                hasBag = true;
                LOGGER.info("How many bags do you have?");
                bagsTotal = Integer.parseInt(s.nextLine());
                bagsTotal++;
                break;
            case "no":
                hasBag = false;
                break;
            default:
                throw new InvalidDataException("Please enter yes or no");

        }
        return bagsTotal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BagCheck)) return false;
        BagCheck bagCheck = (BagCheck) o;
        return bagsTotal == bagCheck.bagsTotal && isHasBag() == bagCheck.isHasBag();
    }

    @Override
    public int hashCode() {
        return Objects.hash(bagsTotal, isHasBag());
    }

    @Override
    public String toString() {
        return String.valueOf(bagsTotal);

    }

    public boolean isHasBag() {
        return hasBag;
    }

    public void setHasBag(boolean hasBag) {
        this.hasBag = hasBag;
    }
}
