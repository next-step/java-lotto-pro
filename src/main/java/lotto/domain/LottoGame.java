package lotto.domain;

import static lotto.view.InputView.*;
import static lotto.view.OutputView.*;

public class LottoGame {

    public void run() {
        int purchaseAmount = getPurchaseAmount();
        // 로또를 구매한다. (금액, 구입수량)
        LottoPurchase lottoPurchase = new LottoPurchase(purchaseAmount);
        // 로또 구매 개수를 출력한다.
        printPurchaseQuantity(lottoPurchase.getPurchaseQuantity());
        // 로또를 발급한다. (구입수량)
        Lottos lottos = new Lottos(LottoIssue.ofAuto(lottoPurchase.getPurchaseQuantity()));
        // 로또번호를 출력한다.
        printLottoNumber(lottos);
        // 당첨번호를 입력받는다.
        // 당첨번호를 확인한다.
    }

    private int getPurchaseAmount() {
        printPurchaseAmount();
        return inputPurchaseAmount();
    }
}
