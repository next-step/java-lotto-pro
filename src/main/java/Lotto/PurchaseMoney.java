package Lotto;

import Lotto.error.ErrorMessage;

public class PurchaseMoney {
    private int money;

    public int getMoney() {
        return money;
    }

    public PurchaseMoney(int money) {
        validation(money);
        this.money = money;
    }

    private void validation(int money) {
        if (money < 1000)
            throw new IllegalArgumentException(ErrorMessage.PurchaseMoneyMinimum.getErrorMsg());

        if (money % 1000 != 0)
            throw new IllegalArgumentException(ErrorMessage.PurchaseMoney1000NotLeft.getErrorMsg());
    }
}
