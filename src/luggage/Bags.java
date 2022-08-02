import java.util.Scanner;
package luggage;

public class Bags {
    private final int size;
    private final int weight;

    public Bags(int size, int weight) {
        this.size = size;
        this.weight = weight;
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

