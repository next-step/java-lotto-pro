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
    private Count manualCount;
    private LottoMachine lottoMachine;
    private LottoNumbers lottoNumbers;
    private LottoRanks lottoRanks;

    public LottoController() {
        scanner = new Scanner(System.in);
    }

    public void start() {
        lottoPurchaseAmount();
        inputManualNumber();
        printBuyingLottoNumbers();
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
            manualCount = Count.of(scanner.nextLine());

            LottoInputView.printManualNumber();
            List<LottoNumber> manualLottoNumbers = new ArrayList<>();
            for (int count = manualCount.getValue(); count > 0; count--) {
                List<Number> numbers = LottoNumberGenerator.of(scanner.nextLine());
                manualLottoNumbers.add(new LottoNumber(numbers));
            }
            lottoMachine.submitManualLottoNumber(manualLottoNumbers);
        } catch (IllegalArgumentException iae) {
            LottoOutputView.printErrorMessage(iae);
            inputManualNumber();
        }
    }

    private void printBuyingLottoNumbers() {
        lottoNumbers = lottoMachine.getLottoNumbers();
        LottoOutputView.printPurchaseResult(manualCount, lottoNumbers);
    }

    private void inputWinningNumber() {
        try {
            LottoInputView.printWinningNumber();
            LottoNumber lottoNumber = new LottoNumber(LottoNumberGenerator.of(scanner.nextLine()));

            LottoInputView.printBonusNumber();
            Number number = Number.of(scanner.nextInt());

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
