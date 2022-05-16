package lotto.domain;

import lotto.constants.Constants;
import lotto.constants.ErrorMessage;

public class Money {
    private static final int MIN_MONEY = 0;
    private final double MATH_ROUND_DIGIT = 100d;
    private final int money;

    private Money(int money) {
        this.money = money;
    }

    public static Money from(int money) {
        if (money < MIN_MONEY) {
            throw new IllegalArgumentException(ErrorMessage.LESS_THEN_MIN_MONEY);
        }
        return new Money(money);
    }

    public boolean isLessThenLottoPrice() {
        return money < Constants.LOTTO_PRICE;
    }

    public int purchaseCount() {
        int purchaseCount = this.money / Constants.LOTTO_PRICE;
        if (purchaseCount > Constants.MAX_PURCHASE_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.MAX_PURCHASE_LOTTO);
        }
        return purchaseCount;
    }

    public double returnRate(Money totalPrizeMoney) {
        double totalPrizeMoneyDouble = totalPrizeMoney.getMoney();
        double purchaseMoneyDouble = this.money;
        double returnRate = totalPrizeMoneyDouble / purchaseMoneyDouble;
        return Math.round(returnRate * MATH_ROUND_DIGIT) / MATH_ROUND_DIGIT;
    }

    public int getMoney() {
        return money;
    }
}
