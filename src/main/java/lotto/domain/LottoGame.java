package lotto.domain;

import static lotto.view.InputView.*;
import static lotto.view.OutputView.*;

public class LottoGame {

    public void run() {
        LottoPurchase lottoPurchase = getPurchaseAmount();
        Lottos lottos = new Lottos(LottoIssue.ofAuto(lottoPurchase.getPurchaseQuantity()));
        printLottoNumber(lottos);
        LottoWinningNumbers lottoWinningNumbers = getWinningNumbers();
    }

    private LottoWinningNumbers getWinningNumbers() {
        return new LottoWinningNumbers(inputWinningNumbers());
    }

    private LottoPurchase getPurchaseAmount() {
        printPurchaseAmount();
        LottoPurchase lottoPurchase = new LottoPurchase(inputPurchaseAmount());
        printPurchaseQuantity(lottoPurchase.getPurchaseQuantity());
        return lottoPurchase;
    }
}
