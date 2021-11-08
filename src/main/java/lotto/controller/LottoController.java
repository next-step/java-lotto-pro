package lotto.controller;

import lotto.domain.LottoIssue;
import lotto.domain.LottoNumbers;
import lotto.domain.LottoPurchase;
import lotto.domain.LottoTicket;

import static lotto.view.InputView.*;
import static lotto.view.OutputView.*;

public class LottoController {

    public void run() {
        LottoPurchase lottoPurchase = getPurchaseAmount();

        LottoTicket lottoTicket = new LottoTicket(LottoIssue.ofAuto(lottoPurchase.getPurchaseQuantity()));
        printLottoNumber(lottoTicket);

        LottoNumbers lottoWinningNumbers = getWinningNumbers();

        play(lottoPurchase, lottoTicket, lottoWinningNumbers);
    }

    private void play(LottoPurchase lottoPurchase, LottoTicket lottoTicket, LottoNumbers lottoWinningNumbers) {
        lottoTicket.compareWinningNumbers(lottoWinningNumbers);
        double rateOfReturn = lottoTicket.getRateOfReturn(lottoPurchase);
        printWinningStatistics(lottoTicket);
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
