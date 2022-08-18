package people;

import java.util.Objects;

public class Staff extends Person {
    private int workId;

    public Staff(String firstName, String lastName, int workId) {
        super(firstName, lastName);
        this.workId = workId;
    }

    public int getWorkId() {
        return workId;
    }

    public void setWorkId(int workId) {
        this.workId = workId;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "workId=" + workId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Staff)) return false;
        Staff staff = (Staff) o;
        return workId == staff.workId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(workId);
    }
}

