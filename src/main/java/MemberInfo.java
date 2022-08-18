import people.Passenger;

import java.util.LinkedList;

public class MemberInfo {
    private static LinkedList<Passenger> members = new LinkedList<>();

    public static void addInfo(Passenger flyer) {
        if(!members.contains(flyer))
            members.add(flyer);
    }
    public static LinkedList<Passenger> getMember() {
        return members;
    }
}
