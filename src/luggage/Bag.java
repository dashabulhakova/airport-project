package luggage;
import exceptions.ExceedLimitException;
import exceptions.NegativeInputException;
import java.util.Scanner;

public class Bag {
    private int size;
    private int weight;
    public static final double weightLimit = 23;
    public static final double sizeLimit = 50;

    public Bag(int size, int weight) {
        this.size = size;
        this.weight = weight;

    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
    public static double checkBagWeight(double weight) throws ExceedLimitException, NegativeInputException {
        if (weight > weightLimit) {
            throw new ExceedLimitException("You bag is too heavy");
        }
        else if (weight < 0) {
            throw new NegativeInputException("Please enter a positive number");
        }
            else return weight;
    }
    public static double checkBagSize(double size) throws ExceedLimitException, NegativeInputException {
        if (size > sizeLimit) {
            throw new ExceedLimitException("You bag is too heavy");
        }
        else if (size < 0) {
            throw new NegativeInputException("Please enter a positive number");
        }
        else return size;
    }
}

