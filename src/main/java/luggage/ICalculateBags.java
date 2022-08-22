package luggage;

import exceptions.ExceedLimitException;

public interface ICalculateBags {
    void validateAmount(int bagsTotal) throws ExceedLimitException;
    void validateSize(double length, double width, double height) throws ExceedLimitException;
}
