package lotto.domain;

import static lotto.domain.message.ErrorMessage.INVALID_BONUS_BALL;

import java.util.Objects;
import lotto.service.LottoNumberValidator;

public class BonusBall {
    private final int number;

    public BonusBall(final int number) {
        LottoNumberValidator.checkRangeOfNumber(number, INVALID_BONUS_BALL);
        this.number = number;
    }

    public static BonusBall convertAndCreate(final String numberString) {
        final int number = parseInt(numberString);
        LottoNumberValidator.checkRangeOfNumber(number, INVALID_BONUS_BALL);
        return new BonusBall(number);
    }

    private static int parseInt(final String numbersString) {
        try {
            return Integer.parseInt(numbersString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_BONUS_BALL.getMessage());
        }
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
