package lotto.domain;

import java.util.Objects;
import lotto.service.LottoNumberValidator;

public class BonusBall {
    private final int number;

    public BonusBall(final int number) {
        LottoNumberValidator.checkRangeOfNumber(number);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "BonusBall{" +
                "number=" + number +
                '}';
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final BonusBall bonusBall = (BonusBall) o;
        return number == bonusBall.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
