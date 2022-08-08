package people;

public class AircraftCapacity implements ICalculateAmount{
    private static int passengerAmount;
    private static int staffAmount;
    private static int bagAmount;

    public AircraftCapacity(int passengerAmount, int staffAmount, int bagAmount) {
        this.passengerAmount = passengerAmount;
        this.staffAmount = staffAmount;
        this.bagAmount = bagAmount;
    }
    public static void passengersEnter() {
        passengerAmount++;
        System.out.println(passengerAmount);
    }
    public static void staffAmount() {
        staffAmount++;
        System.out.println(staffAmount);
    }

    public static int getPassengerAmount() {
        return passengerAmount;
    }

    public static void setPassengerAmount(int passengerAmount) {
        AircraftCapacity.passengerAmount = passengerAmount;
    }

    public static int getStaffAmount() {
        return staffAmount;
    }

    public static void setStaffAmount(int staffAmount) {
        AircraftCapacity.staffAmount = staffAmount;
    }

    public static int getBagAmount() {
        return bagAmount;
    }

    public static void setBagAmount(int bagAmount) {
        AircraftCapacity.bagAmount = bagAmount;
    }
}
