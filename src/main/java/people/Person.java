package people;

public class Person {
    public String firstName;
    public String lastName;
    public String suffix;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    /*
    @Override
    public String getSuffix() {
        return suffix;
    }
    @Override
    public String addSuf(String suffix) {
        IAddS print = (s) -> "Mr" + s;
        System.out.println(print);
        return suffix;
    }*/
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}

