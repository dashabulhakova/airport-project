package enums;

public enum City {
    CITY1("New York"),
    CITY2("Milan"),
    CITY3("Tokyo"),
    CITY4("Paris");
    private final String city;

    City(String city) {
        this.city = city;
    }

    public String getName() {
        return city;
    }
}
