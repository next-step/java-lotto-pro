package lotto.domain.number;

import lotto.exception.*;

public class ManualTicketsCount extends Number {
    private ManualTicketsCount(int manualTicketsCount) {
        super(manualTicketsCount);
        validate(manualTicketsCount);
    }

    public static ManualTicketsCount from(int manualTicketsCount) {
        return new ManualTicketsCount(manualTicketsCount);
    }

    @Override
    protected void validate(int manualTicketsCount) {
        if (manualTicketsCount < 0) {
            throw OutOfBoundException.valueIsLessThan(manualTicketsCount);
        }
    }
}
