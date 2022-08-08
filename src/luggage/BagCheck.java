package luggage;
import java.util.Scanner;
import exceptions.ExceedLimitException;
import exceptions.DataUnavailableException;

public class BagCheck extends Bag implements ICalculateBags{
    private int bagsTotal;
    public BagCheck(int size, int weight, int bagsTotal) {
        super(size, weight);
        try {
            this.bagsTotal = bagsTotal;
            validateAmount(this.bagsTotal);
        }
        catch (Exception e){
            System.out.println("Here:" + e);
        }
    }
    public void bagsAmount() {
        bagsTotal++;
        System.out.println(bagsTotal);
    }
   public void validateAmount(int bagsTotal) throws ExceedLimitException{
        if (bagsTotal > 50) {
            throw new ExceedLimitException("You have too many bags to check in");
        }
   }
    final void bagCheckIn()  throws DataUnavailableException{
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
