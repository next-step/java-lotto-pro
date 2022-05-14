package lotto.model;

import static lotto.utils.InputUtils.convertToInteger;
import static lotto.view.InputView.readPurchaseAmount;

public class Purchase {
    private final Money money;
    private final int count;

    private Purchase(Money money) {
        this.money = money;
        this.count = money.purchaseCount();
    }

    public static Purchase createPurchase() {
        Money money = Money.of(convertToInteger(readPurchaseAmount()));
        return new Purchase(money);
    }
}