package step3.domain;

public class Money {

    private static final int MIN_MONEY = 0;

    private final int element;

    public Money(int element) {
        validate(element);
        this.element = element;
    }

    private void validate(int money) {
        if (money < MIN_MONEY) {
            throw new IllegalArgumentException("금액은 0 이상의 값을 입력해주세요.");
        }
    }

    public int lottoCount(int lottoPrice) {
        return element / lottoPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Money money = (Money) o;

        return element == money.element;
    }

    @Override
    public int hashCode() {
        return element;
    }

    @Override
    public String toString() {
        return "Money{" +
                "element=" + element +
                '}';
    }
}
