package lotto.domain;

import lotto.constants.Constants;
import lotto.constants.ErrorMessage;

import java.util.Objects;

public class ManualCount {
    private final int count;

    private ManualCount(int count) {
        this.count = count;
    }

    public static ManualCount from(int count) {
        return new ManualCount(count);
    }

    public static ManualCount create() {
        return from(Constants.MIN_LOTTO_COUNT);
    }

    public boolean isRemainingCount(int alreadyPurchaseCount) {
        if (alreadyPurchaseCount > count) {
            throw new IllegalArgumentException(String.format(ErrorMessage.GREATER_THEN_MANUAL_COUNT, count));
        }
        int remainingCount = count - alreadyPurchaseCount;
        return remainingCount > Constants.MIN_LOTTO_COUNT;
    }

    public int getCount() {
        return this.count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ManualCount that = (ManualCount) o;
        return count == that.count;
    }

    @Override
    public int hashCode() {
        return Objects.hash(count);
    }

    @Override
    public String toString() {
        return String.valueOf(count);
    }
}
