package lotto.domain;

import lotto.common.Messages;
import lotto.utils.Console;

public class LottoMachine implements Machine {

    @Override
    public void start() {
        PurchaseAmount purchaseAmount = getPurchaseAmount();
        sell(purchaseAmount);
    }

    private PurchaseAmount getPurchaseAmount() {
        System.out.println(Messages.PURCHASE_AMOUNT_INPUT);
        int amount = Console.readInt();
        return new PurchaseAmount(amount);
    }

    private void sell(PurchaseAmount purchaseAmount) {
        int purchasedLottoCount = getPurchasedLottoCount(purchaseAmount);
    }

    private int getPurchasedLottoCount(PurchaseAmount purchaseAmount) {
        int count = purchaseAmount.buyLotto();
        System.out.println(Messages.getPurchasedLottoCount(count));
        return count;
    }
}
