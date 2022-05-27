package lotto.domain;

import util.ValidationUtil;

public class PurchaseMoney {
    private static final String ERROR_MESSAGE_MONEY_NEGATIVE = "[ERROR] 금액은 음수가 될 수 없습니다";
    private static final String ERROR_MESSAGE_MONEY_LOWER_THAN_PRICE = "[ERROR] 금액이 로또 가격 미만입니다.";

    private static final int LOTTO_PRICE = 1000;

    private final int money;

    public PurchaseMoney(int money) {
        validate(money);

        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public int getPurchasableQuantity() {
        return money / LOTTO_PRICE;
    }

    private void validate(int money) {
        ValidationUtil.validateCorrectArguments(money < 0, ERROR_MESSAGE_MONEY_NEGATIVE);
        ValidationUtil.validateCorrectArguments(money < LOTTO_PRICE, ERROR_MESSAGE_MONEY_LOWER_THAN_PRICE);
    }

    public double calculateEarningsRate(int resultMoney) {
        return (double) resultMoney / money;
    }
}
