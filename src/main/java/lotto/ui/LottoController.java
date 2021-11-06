package lotto.ui;

import lotto.BuyAmount;
import lotto.LottoNumbers;
import lotto.LottoNumbersGroup;
import lotto.LottoResults;

import java.util.Scanner;

public class LottoController {
    private static Scanner scanner;

    public void startGame() {
        int buyPrice = inputBuyPrice();
        BuyAmount buyAmount = new BuyAmount(buyPrice);
        LottoNumbersGroup lottoNumbersGroup = new LottoNumbersGroup(buyAmount);

        showBuyStats(buyAmount, lottoNumbersGroup);

        String prizeLottoNumbersText = inputPrizeLottoNumbers();
        LottoNumbers prizeLottoNumbers = new LottoNumbers(prizeLottoNumbersText);

        showResults(buyAmount, lottoNumbersGroup, prizeLottoNumbers);
    }

    private int inputBuyPrice() {
        LottoMessage.showAskBuyPriceMessage();
        scanner = getScanner();
        return scanner.nextInt();
    }

    private void showBuyStats(BuyAmount buyAmount, LottoNumbersGroup lottoNumbersGroup) {
        LottoInputView lottoInputView = new LottoInputView(buyAmount, lottoNumbersGroup);
        lottoInputView.showBuyStats();
    }

    private String inputPrizeLottoNumbers() {
        LottoMessage.showAskPrizeLottoNumbersMessage();
        scanner = getScanner();
        return scanner.nextLine();
    }

    private void showResults(BuyAmount buyAmount, LottoNumbersGroup lottoNumbersGroup,
                             LottoNumbers prizeLottoNumbers) {
        LottoResults lottoResults = lottoNumbersGroup.getLottoResults(prizeLottoNumbers);
        LottoResultsView lottoResultsView = new LottoResultsView(buyAmount, lottoResults);
        lottoResultsView.showResults();
    }

    private static Scanner getScanner() {
        return new Scanner(System.in);
    }


}
