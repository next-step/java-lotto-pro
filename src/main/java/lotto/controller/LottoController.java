package lotto.controller;

import java.util.Scanner;
import lotto.model.LottoMachine;
import lotto.model.LottoNumber;
import lotto.model.LottoNumberGenerator;
import lotto.model.LottoNumbers;
import lotto.model.LottoRanks;
import lotto.model.Number;
import lotto.model.WinningLottoNumber;
import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;

public class LottoController {
    private final Scanner scanner;
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
            lottoNumbers = lottoMachine.getLottoNumbers();
            LottoOutputView.printPurchaseResult(lottoNumbers);
        } catch (IllegalArgumentException iae) {
            LottoOutputView.printErrorMessage(iae);
            buy();
        }
    }

    private void inputWinningNumber() {
        try {
            LottoInputView.printWinningNumber();
            LottoNumber lottoNumber = new LottoNumber(LottoNumberGenerator.of(scanner.nextLine()));
            LottoInputView.printBonusNumber();
            Number number = Number.of(scanner.nextInt());
            WinningLottoNumber winningLottoNumber = new WinningLottoNumber(lottoNumber, number);

            lottoRanks = lottoNumbers.resultLottoRanks(winningLottoNumber);
            LottoOutputView.printRankResult(lottoRanks);
        } catch (IllegalArgumentException iae) {
            LottoOutputView.printErrorMessage(iae);
            inputWinningNumber();
        }
    }

    private void profitRate() {
        LottoOutputView.printProfitRate(lottoRanks);
    }
}
