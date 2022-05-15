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

    public void decrease() {
        if (this.count == 0) {
            throw new IllegalStateException("현재 횟수가 0이라 감소할 수 없습니다.");
        }
        this.count--;
    }

    public boolean isZero() {
        return this.count == 0;
    }

    public int getCount() {
        return count;
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
