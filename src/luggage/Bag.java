package luggage;
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
    public static double checkBagWeight(double weight) throws NegativeInputException {
        if (weight > weightLimit) {
            throw new NegativeInputException("Your bag weight must be 23 kg");
        }
        else return weight;
    }
    public static double checkBagSize(double size) throws NegativeInputException {
        if (size > sizeLimit) {
            throw new NegativeInputException("Your bag size must be 50 cm");
        }
        else return size;
    }
    final void bagCheckin() {
        Scanner s = new Scanner(System.in);
        String decision;
        boolean choose = true;
        while (choose) {
            System.out.println("Do you have any bags to check in? yes/no");
            decision = s.nextLine();

            switch(decision) {
                case "yes":
                    choose = true;
                    break;
                case "no":
                    choose = false;
                    break;
                default:
                    System.out.println("Please enter yes or no");
                    //decision = s.nextLine();
                    break;
            }
        }

    }
}

