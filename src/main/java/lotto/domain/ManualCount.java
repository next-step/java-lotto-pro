package lotto.domain;

import lotto.constants.ErrorMessage;

import java.util.Objects;

public class ManualCount {
    private static final int MIN_COUNT = 0;
    private final int count;

    private ManualCount(int count) {
        this.count = count;
    }

    public static ManualCount from(int count, Money purchaseMoney) {
        int purchaseCount = purchaseMoney.purchaseCount();
        if (count < MIN_COUNT || count > purchaseCount) {
            throw new IllegalArgumentException(String.format(ErrorMessage.OUT_OF_RANGE_MANUAL_COUNT, purchaseCount));
        }
        return new ManualCount(count);
    }

    public static ManualCount create() {
        return from(MIN_COUNT, Money.create());
    }

    public int autoPurchaseCount(Money purchaseMoney) {
        return purchaseMoney.purchaseCount() - count;
    }

    public boolean isRemainingCount(int purchaseCount) {
        if (purchaseCount > count) {
            throw new IllegalArgumentException(String.format(ErrorMessage.GREATER_THEN_MANUAL_COUNT, count));
        }
        int remainingCount = count - purchaseCount;
        return remainingCount > MIN_COUNT;
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
