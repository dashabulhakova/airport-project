package luggage;
import exceptions.ExceedLimitException;
import exceptions.NegativeInputException;

import java.util.Objects;
import java.util.Scanner;

public class Bag {
    private int size;
    private int weight;
    public static final double weightLimit = 23;
    public static final double sizeLimit = 50;

    public Bag() {};

    public Bag(int size, int weight) {
        this.size = size;
        this.weight = weight;

    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
    public static int checkBagWeight(int weight, int size) throws ExceedLimitException, NegativeInputException {
        return (Math.round(size + weight));
    }

    @Override
    public String toString() {
        return "Bag{" +
                "size=" + size +
                ", weight=" + weight +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bag)) return false;
        Bag bag = (Bag) o;
        return getSize() == bag.getSize() && getWeight() == bag.getWeight();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSize(), getWeight());
    }
}

