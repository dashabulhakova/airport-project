package enums;

import luggage.BagCheck;
import org.apache.log4j.Logger;

public enum Meal {
    VE(1, "Vegan"),
    VG(2, "Vegeterian"),
    H( 3, "Halaal"),
    SF(4, "Sea Food"),
    LF(5, "Lactose Free"),
    R( 6, "Regular");

    public String mealType;
    public int option;
    private static final Logger LOGGER = Logger.getLogger(BagCheck.class.getName());

    Meal(int option, String mealType) {
        this.mealType = mealType;
        this.option = option;
    }

    public int getOption() {
        return option;
    }

    public void requestMeal() {
        switch (option) {
            case 1:
                LOGGER.info(Meal.VE.mealType + ": " +
                        "\nToday on the menu is vegan pasta.");
                break;
            default:
                LOGGER.info(Meal.R.mealType);
        }

    }

}
