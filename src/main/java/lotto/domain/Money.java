package lotto.domain;

public class Money {

    public static final int LOTTO_TICKET_PRICE = 1_000;

    private static final String MONEY_NEGATIVE_ERROR = "[ERROR] 금액은 양수여야 합니다.";
    private static final String MONEY_UNDER_PRICE_ERROR = "[ERROR] 금액이 로또 가격보다 낮습니다.";

    private final int money;

    private Money(int money) {
        validateMoney(money);
        this.money = money;
    }

    private void validateMoney(int money) {
        if (money <= 0) {
            throw new IllegalArgumentException(MONEY_NEGATIVE_ERROR);
        }
        if (money < LOTTO_TICKET_PRICE) {
            throw new IllegalArgumentException(MONEY_UNDER_PRICE_ERROR);
        }
    }

    public int getMoney() {
        return money;
    }

    public static Money from(int money) {
        return new Money(money);
    }

    public int getQuantityFromMoney() {
        return money/LOTTO_TICKET_PRICE;
    }
}
