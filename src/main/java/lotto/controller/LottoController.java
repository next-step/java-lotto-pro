package lotto.controller;

import java.util.Scanner;
import lotto.model.LottoMachine;
import lotto.model.LottoNumber;
import lotto.model.LottoNumbers;
import lotto.model.LottoRanks;
import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;

public class LottoController {
    private final Scanner scanner;
    private LottoMachine lottoMachine;
    private LottoNumbers lottoNumbers;

    public LottoController() {
        scanner = new Scanner(System.in);
    }

    public void start() {
        buy();
        inputWinningNumber();
    }

    private void buy() {
        try {
            LottoInputView.printPurchase();
            lottoMachine = new LottoMachine(scanner.nextLine());
            lottoNumbers = lottoMachine.getLottoNumbers();
            LottoOutputView.printPurchaseQuantity(lottoMachine.getLottoPurchaseQuantity());
            LottoOutputView.printPurchaseLottoNumbers(lottoNumbers);
        } catch (IllegalArgumentException iae) {
            LottoOutputView.printErrorMessage(iae);
            buy();
        }
    }

    private void inputWinningNumber() {
        try {
            LottoInputView.printWinningNumber();
            LottoNumber winningNumber = new LottoNumber(scanner.nextLine());
            LottoRanks lottoRanks = lottoNumbers.getLottoRanks(winningNumber);
            LottoOutputView.printRankResult(lottoRanks);
        } catch (IllegalArgumentException iae) {
            LottoOutputView.printErrorMessage(iae);
            inputWinningNumber();
        }
    }
}
