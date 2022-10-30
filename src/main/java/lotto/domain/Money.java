package lotto.domain;

import java.util.Objects;

public class Money implements Comparable<Money> {

    private final long won;

    public Money(String won) {
        this(parseLong(won));
    }

    public Money(long won) {
        this.won = won;
    }

    private static long parseLong(String won) {
        try {
            return Long.parseLong(won);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력할 수 있습니다.");
        }
    }

    public boolean greaterEqualThan(Money target) {
        return this.compareTo(target) >= 0;
    }

    public int quotient(Money target) {
        return (int) (this.won / target.won);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Money)) return false;
        Money money = (Money) o;
        return won == money.won;
    }

    @Override
    public int hashCode() {
        return Objects.hash(won);
    }

    @Override
    public int compareTo(Money target) {
        if (this.won > target.won) {
            return 1;
        }
        if (this.won == target.won) {
            return 0;
        }
        return -1;
    }
}
