package lotto.domain;

import java.util.Objects;

public class Money {

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
}
