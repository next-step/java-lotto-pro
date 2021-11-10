package lotto.controller;

import lotto.domain.LottoIssue;
import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.domain.LottoPurchase;
import lotto.domain.LottoResult;
import lotto.domain.LottoTicket;
import lotto.domain.LottoWinningNumbers;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static lotto.view.InputView.inputBonusNumber;
import static lotto.view.InputView.inputLottoNumbers;
import static lotto.view.InputView.inputManualPurchaseQuantity;
import static lotto.view.InputView.inputPurchaseAmount;
import static lotto.view.OutputView.printInputLottoBonusNumber;
import static lotto.view.OutputView.printInputManualLottoNumbers;
import static lotto.view.OutputView.printInputWinningNumbers;
import static lotto.view.OutputView.printLottoNumber;
import static lotto.view.OutputView.printManualPurchaseQuantity;
import static lotto.view.OutputView.printPurchaseAmount;
import static lotto.view.OutputView.printPurchaseQuantity;
import static lotto.view.OutputView.printWinningStatistics;

public class LottoController {

    public void run() {
        LottoPurchase lottoPurchase = inputLottoPurchase();

        LottoTicket lottoTicket = LottoIssue.of(lottoPurchase, inputManualLottoNumbers(lottoPurchase));

        printPurchaseQuantity(lottoPurchase);
        printLottoNumber(lottoTicket);

        LottoWinningNumbers lottoWinningNumbers = new LottoWinningNumbers(inputLottoWinningNumbers(), inputLottoBonusNumber());

        play(lottoPurchase, lottoTicket, lottoWinningNumbers);
    }

    private void play(LottoPurchase lottoPurchase, LottoTicket lottoTicket, LottoWinningNumbers lottoWinningNumbers) {
        LottoResult lottoResult = LottoResult.of(lottoPurchase, lottoTicket, lottoWinningNumbers);
        printWinningStatistics(lottoResult);
    }

    private Map<Integer, List<Integer>> inputManualLottoNumbers(LottoPurchase lottoPurchase) {
        Map<Integer, List<Integer>> inputManualLottoNumbers = new TreeMap<>();
        if (lottoPurchase.getManualPurchaseQuantity() != 0) {
            printInputManualLottoNumbers();
        }

        for (int i = 0; i < lottoPurchase.getManualPurchaseQuantity(); i++) {
            inputManualLottoNumbers.put(i, inputLottoNumbers());
        }

        return inputManualLottoNumbers;
    }

    private LottoNumber inputLottoBonusNumber() {
        printInputLottoBonusNumber();
        return LottoNumber.from(inputBonusNumber());
    }

    private LottoNumbers inputLottoWinningNumbers() {
        printInputWinningNumbers();
        return new LottoNumbers(inputLottoNumbers());
    }

    private LottoPurchase inputLottoPurchase() {
        printPurchaseAmount();
        LottoPurchase lottoPurchase = new LottoPurchase(inputPurchaseAmount());

        printManualPurchaseQuantity();
        lottoPurchase.buyManual(inputManualPurchaseQuantity());

        return lottoPurchase;
    }

}
