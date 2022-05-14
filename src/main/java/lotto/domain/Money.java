package lotto.domain;

public class Money {
    private final int value;

    private Money(int value) {
        validate(value);
        this.value = value;
    }

    private void validate(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("돈은 0보다 작을 수 없습니다.");
        }
    }

    public static Money from(int money) {
        return new Money(money);
    }
}
