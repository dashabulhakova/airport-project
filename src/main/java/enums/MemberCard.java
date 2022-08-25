package enums;

public enum MemberCard {
    BRONZE("Bronze", 1, 0.05),//years of membership, discount
    SILVER("Silver", 3, 0.1),
    GOLD("Gold", 5, 0.15);

    private String level;
    private int yearsAsMember;
    private double discount;

    MemberCard(String level, int yearsAsMember, double discount) {
        this.level = level;
        this.yearsAsMember = yearsAsMember;
        this.discount = discount;
    }
    public double discountedMembership(double price){
        return price - (price * discount);
    }

    public String getLevel() {
        return level;
    }

    public int getYearsAsMember() {
        return yearsAsMember;
    }

    public double getDiscount() {
        return discount;
    }
}
