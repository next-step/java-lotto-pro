package lotto.domain;

import java.util.Objects;

public class PurchaseCount {

    private final int count;

    public PurchaseCount(int count) {
        if (count < 0) {
            throw new IllegalArgumentException("구입 갯수는 0개 이상이어야 합니다. (입력값: " + count + ")");
        }
        this.count = count;
    }

    public boolean isGreaterThanZero() {
        return count > 0;
    }

    public PurchaseCount minus(int count) {
        return new PurchaseCount(this.count - count);
    }

    public boolean isGreaterThan(int inputCount) {
        return this.count > inputCount;
    }

    public int gap(int inputCount) {
        return inputCount - this.count;
    }

    public boolean isZero() {
        return this.count == 0;
    }

    public int getCount() {
        return count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PurchaseCount that = (PurchaseCount) o;
        return count == that.count;
    }

    @Override
    public int hashCode() {
        return Objects.hash(count);
    }
}
