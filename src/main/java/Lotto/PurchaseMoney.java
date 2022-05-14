package Lotto;

import Lotto.error.ErrorMessage;

public class PurchaseMoney {
    private int money;

    public int getMoney() {
        return money;
    }

    public PurchaseMoney(int money) {
        if(!validation(money)) {
            throw new IllegalArgumentException(ErrorMessage.PurchaseMoneyMinimum.getErrorMsg());
        }

        this.money = money;
    }

    private boolean validation(int money) {
        if (money < 1000)
            return false;
        return true;
    }
}
