package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import lotto.model.Count;
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
    private LottoMachine lottoMachine;
    private LottoRanks lottoRanks;

    public LottoController() {
        scanner = new Scanner(System.in);
    }

    public void start() {
        lottoPurchaseAmount();
        inputManualNumber();
        inputWinningNumber();
        profitRate();
    }

    private void lottoPurchaseAmount() {
        try {
            LottoInputView.printLottoPurchaseAmount();
            lottoMachine = new LottoMachine(scanner.nextLine());
        } catch (IllegalArgumentException iae) {
            LottoOutputView.printErrorMessage(iae);
            lottoPurchaseAmount();
        }
    }

    private void inputManualNumber() {
        try {
            LottoInputView.printManualPurchaseCount();
            Count manualCount = Count.of(scanner.nextLine());
            LottoInputView.printManualNumber();
            List<LottoNumber> manualLottoNumbers = new ArrayList<>();
            while (!manualCount.isZero()) {
                List<Number> numbers = LottoNumberGenerator.of(scanner.nextLine());
                manualLottoNumbers.add(new LottoNumber(numbers));
                manualCount.decrease();
            }
            lottoMachine.submitManualLottoNumber(manualLottoNumbers);
        } catch (IllegalArgumentException iae) {
            LottoOutputView.printErrorMessage(iae);
            inputManualNumber();
        }
    }

    private void inputWinningNumber() {
        try {
            LottoInputView.printWinningNumber();
            LottoNumber lottoNumber = new LottoNumber(LottoNumberGenerator.of(scanner.nextLine()));

            LottoInputView.printBonusNumber();
            Number number = Number.of(scanner.nextInt());

            LottoNumbers lottoNumbers = lottoMachine.getLottoNumbers();
            lottoRanks = lottoNumbers.resultLottoRanks(new WinningLottoNumber(lottoNumber, number));
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
