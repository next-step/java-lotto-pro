package lotto.domain;

import java.util.Objects;

public class Money {
    private static final String NUMBER_FORMAT_REGEX = "^[0-9]*$";
    public static final int PRICE_PER_LOTTO = 1_000;

    private final int money;

    public Money(String money) {
        this.money = validateMoney(money);
    }

    private int validateMoney(String money) {
        validateFormat(money);
        int parsedMoney = Integer.parseInt(money);
        validateMinimumSize(parsedMoney);
        validateSize(parsedMoney);
        return parsedMoney;
    }

    private void validateFormat(String money) {
        if (!money.matches(NUMBER_FORMAT_REGEX)) {
            throw new IllegalArgumentException("금액은 숫자 형식으로 입력해야 합니다.");
        }
    }

    private void validateSize(int parsedMoney) {
        if (parsedMoney % PRICE_PER_LOTTO != 0) {
            throw new IllegalArgumentException("금액을 잘못 입력했습니다.");
        }
    }

    private void validateMinimumSize(int parsedMoney) {
        if (parsedMoney < PRICE_PER_LOTTO) {
            throw new IllegalArgumentException("금액이 부족합니다.");
        }
    }

    public int calculateLottoCount() {
        return this.money / PRICE_PER_LOTTO;
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
        return Objects.hash(money);
    }
}
