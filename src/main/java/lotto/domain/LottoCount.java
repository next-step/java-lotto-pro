package lotto.domain;

import static lotto.common.ErrorMessage.EXCEED_MONEY_ERROR;
import static lotto.common.ErrorMessage.NUMBER_FORMAT_ERROR;

import java.util.Objects;

public class LottoCount {
    private static final String NUMBER_FORMAT_REGEX = "^[0-9]*$";

    private final int count;

    private LottoCount(int count) {
        this.count = count;
    }

    public static LottoCount createValidLottoCount(String value, Money money) {
        validateFormat(value);
        int parsedCount = Integer.parseInt(value);
        validateExceedMoney(money, parsedCount);
        return new LottoCount(parsedCount);
    }

    private static void validateExceedMoney(Money money, int parsedCount) {
        if (parsedCount > money.calculateLottoCount()) {
            throw new IllegalArgumentException(EXCEED_MONEY_ERROR.getErrorMessage());
        }
    }

    private static void validateFormat(String value) {
        if (!value.matches(NUMBER_FORMAT_REGEX)) {
            throw new IllegalArgumentException(NUMBER_FORMAT_ERROR.getErrorMessage());
        }
    }

    public int calculateAutoLottoCount(Money money) {
        return money.calculateLottoCount() - this.count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoCount that = (LottoCount) o;
        return count == that.count;
    }

    @Override
    public int hashCode() {
        return Objects.hash(count);
    }
}
