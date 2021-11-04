package lotto.domain;

import static lotto.view.InputView.*;
import static lotto.view.OutputView.*;

public class LottoGame {

    public void run() {
        int purchaseAmount = getPurchaseAmount();
        // 로또를 구매한다. (금액, 구입수량)
        LottoPurchase lottoPurchase = new LottoPurchase(purchaseAmount);
    }

    private int getPurchaseAmount() {
        printPurchaseAmount();
        return inputPurchaseAmount();
    }
}
