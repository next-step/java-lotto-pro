package lotto.domain;

public class Money {

    public static final int DEFAULT_LOTTO_PRICE = 1000;
    public static final int MINIMUM_COUNT = 0;
    private final int money;

    private Money(int money) {
        this.money = money;
    }

    public static Money from(int money) {
        validMoney(money);
        return new Money(money);
    }

    public static Money fromCount(int count) {
        validCount(count);
        return new Money(count * DEFAULT_LOTTO_PRICE);
    }

    public int availableLottoSize() {
        return money / DEFAULT_LOTTO_PRICE;
    }

    public int checkPossibleLottoCount(int count) {
        if (money < count * DEFAULT_LOTTO_PRICE) {
            throw new IllegalArgumentException("구매 가능 수를 초과했습니다.");
        }
        return count;
    }

    public Money minus(Money money) {
        return new Money(this.money - money.money);
    }

    private static void validMoney(int money) {
        if (money < DEFAULT_LOTTO_PRICE) {
            throw new IllegalArgumentException(DEFAULT_LOTTO_PRICE + "원 이상의 금액을 입력하세요.");
        }
    }

    private static void validCount(int count) {
        if (count < MINIMUM_COUNT) {
            throw new IllegalArgumentException("양수를 입력해주세요.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Money money1 = (Money) o;

        return money == money1.money;
    }

    @Override
    public int hashCode() {
        return money;
    }
}
