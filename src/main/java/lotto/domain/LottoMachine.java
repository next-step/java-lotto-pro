package lotto.domain;

import lotto.common.Messages;
import lotto.utils.Console;

public class LottoMachine implements Machine {

    @Override
    public void start() {
        PurchaseAmount purchaseAmount = getPurchaseAmount();
    }

    private PurchaseAmount getPurchaseAmount() {
        System.out.println(Messages.PURCHASE_AMOUNT_INPUT);
        int amount = Console.readInt();
        return new PurchaseAmount(amount);
    }
}
