package lotto.controller;

import lotto.domain.LottoIssue;
import lotto.domain.LottoNumbers;
import lotto.domain.LottoPurchase;
import lotto.domain.Lottos;

import static lotto.view.InputView.*;
import static lotto.view.OutputView.*;

public class LottoController {

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
        printInputWinningNumbers();
        return new LottoNumbers(inputWinningNumbers());
    }

    private LottoPurchase getPurchaseAmount() {
        printPurchaseAmount();
        LottoPurchase lottoPurchase = new LottoPurchase(inputPurchaseAmount());
        printPurchaseQuantity(lottoPurchase.getPurchaseQuantity());
        return lottoPurchase;
    }
}
