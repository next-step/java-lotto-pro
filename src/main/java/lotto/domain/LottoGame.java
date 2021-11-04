package lotto.domain;

import static lotto.view.InputView.*;
import static lotto.view.OutputView.*;

public class LottoGame {

    public void run() {
        LottoPurchase lottoPurchase = getPurchaseAmount();
        Lottos lottos = new Lottos(LottoIssue.ofAuto(lottoPurchase.getPurchaseQuantity()));
        // 로또번호를 출력한다.
        printLottoNumber(lottos);

        // 당첨번호를 입력받는다.
        LottoPrizeNumbers lottoPrizeNumbers = getPrizeNumbers();
        // 당첨번호를 확인한다.
    }

    private LottoPrizeNumbers getPrizeNumbers() {
        return new LottoPrizeNumbers(inputPrizeNumbers());
    }

    private LottoPurchase getPurchaseAmount() {
        printPurchaseAmount();
        LottoPurchase lottoPurchase = new LottoPurchase(inputPurchaseAmount());
        printPurchaseQuantity(lottoPurchase.getPurchaseQuantity());
        return lottoPurchase;
    }
}
