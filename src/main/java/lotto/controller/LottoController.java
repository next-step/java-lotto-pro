package lotto.controller;

import lotto.domain.LottoIssue;
import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.domain.LottoPurchase;
import lotto.domain.LottoResult;
import lotto.domain.LottoTicket;
import lotto.domain.LottoWinningNumbers;

import static lotto.view.InputView.inputBonusNumber;
import static lotto.view.InputView.inputPurchaseAmount;
import static lotto.view.InputView.inputWinningNumbers;
import static lotto.view.OutputView.printInputLottoBonusNumber;
import static lotto.view.OutputView.printInputWinningNumbers;
import static lotto.view.OutputView.printLottoNumber;
import static lotto.view.OutputView.printPurchaseAmount;
import static lotto.view.OutputView.printPurchaseQuantity;
import static lotto.view.OutputView.printWinningStatistics;

public class LottoController {

    public void run() {
        LottoPurchase lottoPurchase = inputLottoPurchase();

        LottoTicket lottoTicket = LottoIssue.ofAuto(lottoPurchase.getPurchaseQuantity());
        printLottoNumber(lottoTicket);

        LottoWinningNumbers lottoWinningNumbers = new LottoWinningNumbers(inputLottoWinningNumbers(), inputLottoBonusNumber());

        play(lottoPurchase, lottoTicket, lottoWinningNumbers);
    }

    private LottoNumber inputLottoBonusNumber() {
        printInputLottoBonusNumber();
        return new LottoNumber(inputBonusNumber());
    }

    private void play(LottoPurchase lottoPurchase, LottoTicket lottoTicket, LottoWinningNumbers lottoWinningNumbers) {
        LottoResult lottoResult = new LottoResult(lottoPurchase, lottoTicket, lottoWinningNumbers);
        printWinningStatistics(lottoResult);
    }

    private LottoNumbers inputLottoWinningNumbers() {
        printInputWinningNumbers();
        return new LottoNumbers(inputWinningNumbers());
    }

    private LottoPurchase inputLottoPurchase() {
        printPurchaseAmount();
        LottoPurchase lottoPurchase = new LottoPurchase(inputPurchaseAmount());
        printPurchaseQuantity(lottoPurchase.getPurchaseQuantity());
        return lottoPurchase;
    }

}
