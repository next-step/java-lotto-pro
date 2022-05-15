package lotto.model;

import java.util.Objects;

public class Count implements Comparable<Count> {
    private int count;

    private Count(int count) {
        if (count <= 0) {
            throw new IllegalArgumentException("횟수는 음수가 될 수 없습니다.");
        }
        this.count = count;
    }

    public static Count of(int count) {
        return new Count(count);
    }

    public static Count of(String count) {
        try {
            return new Count(Integer.parseInt(count));
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("횟수는 Integer 값만 올 수 있습니다.");
        }
    }

    public int subtract(Count otherCount) {
        if (compareTo(otherCount) < 0) {
            throw new IllegalStateException("현재 횟수보다 큰 값으로 뺄 수 없습니다.");
        }
        return this.count - otherCount.count;
    }

    public int getValue() {
        return this.count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Count count1 = (Count) o;
        return count == count1.count;
    }

    @Override
    public int hashCode() {
        return Objects.hash(count);
    }

    @Override
    public int compareTo(Count inputCount) {
        return this.count - inputCount.count;
    }
}
