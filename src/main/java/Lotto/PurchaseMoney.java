package Lotto;

import Lotto.error.ErrorMessage;

public class PurchaseMoney {
    public static int LOTTO_PURCHASE_UNIT = 1000;

    private int money = 0;

    public int getMoney() {
        return money;
    }

    public PurchaseMoney() {
    }

    public PurchaseMoney(int money) {
        validation(money);
        this.money = money;
    }

    private void validation(int money) {
        if (money < LOTTO_PURCHASE_UNIT)
            throw new IllegalArgumentException(ErrorMessage.PurchaseMoneyMinimum.getErrorMsg());

        if (money % LOTTO_PURCHASE_UNIT != 0)
            throw new IllegalArgumentException(ErrorMessage.PurchaseMoney1000NotLeft.getErrorMsg());
    }

    public void manualValidation(int manualCount) {
        if (money < manualCount * LOTTO_PURCHASE_UNIT)
            throw new IllegalArgumentException(ErrorMessage.OverManualPrice.getErrorMsg());
    }
}
