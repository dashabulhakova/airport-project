package luggage;
import java.util.Scanner;
import exceptions.ExceedLimitException;
import exceptions.InvalidDataException;

public class BagCheck extends Bag implements ICalculateBags {
    private int bagsTotal = 0;
    private boolean hasBag;

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
        if (bagsTotal > 5) {
            throw new ExceedLimitException("You have too many bags to check in");
        }
    }

    public int bagCheckIn() throws InvalidDataException {
        Scanner s = new Scanner(System.in);
        String decision;
        boolean choose = true;
        while (hasBag) {
            System.out.println("Do you have any bags to check in? yes/no");
            decision = s.nextLine();
            switch (decision) {
                case "yes":
                    hasBag = true;
                    System.out.println("How many bags do you have?");
                    bagsTotal = Integer.parseInt(s.nextLine());
                    bagsTotal++;
                    break;
                case "no":
                    hasBag = false;
                    break;
                default:
                    throw new InvalidDataException("Please enter yes or no");

            }

        }
        return bagsTotal;
    }

    public boolean isHasBag() {
        return hasBag;
    }

    public void setHasBag(boolean hasBag) {
        this.hasBag = hasBag;
    }
}
