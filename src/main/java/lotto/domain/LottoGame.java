package lotto.domain;

import static lotto.view.InputView.*;
import static lotto.view.OutputView.*;

public class LottoGame {

    public void run() {
        LottoPurchase lottoPurchase = getPurchaseAmount();

        Lottos lottos = new Lottos(LottoIssue.ofAuto(lottoPurchase.getPurchaseQuantity()));
        printLottoNumber(lottos);

        LottoNumbers lottoWinningNumbers = getWinningNumbers();

        play(lottoPurchase, lottos, lottoWinningNumbers);
    }

    private void play(LottoPurchase lottoPurchase, Lottos lottos, LottoNumbers lottoWinningNumbers) {
        lottos.compareWinningNumbers(lottoWinningNumbers);
        double rateOfReturn = lottos.getRateOfReturn(lottoPurchase);
        printWinningStatistics(lottos);
        printRateOfReturn(rateOfReturn);
    }

    private LottoNumbers getWinningNumbers() {
        return new LottoNumbers(inputWinningNumbers());
    }

    private LottoPurchase getPurchaseAmount() {
        printPurchaseAmount();
        LottoPurchase lottoPurchase = new LottoPurchase(inputPurchaseAmount());
        printPurchaseQuantity(lottoPurchase.getPurchaseQuantity());
        return lottoPurchase;
    }
}
