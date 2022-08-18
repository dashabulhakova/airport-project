package luggage;

import exceptions.ExceedLimitException;

public interface ICalculateBags {
    void validateAmount(int bagsTotal) throws ExceedLimitException;
}
