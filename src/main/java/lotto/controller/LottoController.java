package lotto.controller;

import java.util.Scanner;
import lotto.model.LottoMachine;
import lotto.model.LottoNumber;
import lotto.model.LottoNumbers;
import lotto.model.LottoProfit;
import lotto.model.LottoPurchaseQuantity;
import lotto.model.LottoRanks;
import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;

public class LottoController {
    private final Scanner scanner;
    private LottoPurchaseQuantity lottoPurchaseQuantity;
    private LottoNumbers lottoNumbers;
    private LottoRanks lottoRanks;

    public LottoController() {
        scanner = new Scanner(System.in);
    }

    public void start() {
        buy();
        inputWinningNumber();
        profitRate();
    }

    private void buy() {
        try {
            LottoInputView.printPurchase();
            LottoMachine lottoMachine = new LottoMachine(scanner.nextLine());
            lottoPurchaseQuantity = lottoMachine.getLottoPurchaseQuantity();
            lottoNumbers = lottoMachine.getLottoNumbers();
            LottoOutputView.printPurchaseQuantity(lottoPurchaseQuantity);
            LottoOutputView.printPurchaseLottoNumbers(lottoNumbers);
        } catch (IllegalArgumentException iae) {
            LottoOutputView.printErrorMessage(iae);
            buy();
        }
    }

    private void inputWinningNumber() {
        try {
            LottoInputView.printWinningNumber();
            LottoNumber winningNumber = LottoNumber.of(scanner.nextLine());
            lottoRanks = lottoNumbers.getLottoRanks(winningNumber);
            LottoOutputView.printRankResult(lottoRanks);
        } catch (IllegalArgumentException iae) {
            LottoOutputView.printErrorMessage(iae);
            inputWinningNumber();
        }
    }

    private void profitRate() {
        LottoProfit lottoProfit = LottoProfit.calculate(lottoPurchaseQuantity, lottoRanks);
        LottoOutputView.printProfitRate(lottoProfit);
    }
}
