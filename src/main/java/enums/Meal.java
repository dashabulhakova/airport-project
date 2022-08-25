package enums;
public enum Meal {
    VE(1, "Vegan"),
    VG(2, "Vegetarian"),
    H( 3, "Halal"),
    SF(4, "Sea Food"),
    LF(5, "Lactose Free"),
    R( 6, "Regular"),
    D( 7, "Extra option");

    private String mealType;
    private int option;

    Meal(int option, String mealType) {
        this.mealType = mealType;
        this.option = option;
    }

    public String getMealType() {
        return mealType;
    }
    public int getOption() {
        return option;
    }
}
