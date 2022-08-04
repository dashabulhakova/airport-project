package luggage;
import exceptions.NegativeInputException;
import java.util.Scanner;

public class Bags {
    private int size;
    private int weight;
    public static final double weightLimit = 50;
    public static final double sizeLimit = 18;

    public Bags(int size, int weight) {
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
    public static double checkBags(double weight, double size) throws NegativeInputException {
        if (weight > weightLimit || size > sizeLimit) {
            throw new NegativeInputException("Your bag weight or size exceeds the limit");
        }
        else return weight;
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

