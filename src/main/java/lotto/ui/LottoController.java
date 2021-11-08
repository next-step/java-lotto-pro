package lotto.ui;

import lotto.domain.*;

import java.util.Scanner;

public class LottoController {
    private static Scanner scanner;

    public void startGame() {
        scanner = new Scanner(System.in);
        int buyPrice = inputBuyPrice();
        int manualBuyAmount = getManualBuyAmount();
        BuyAmount buyAmount = new BuyAmount(buyPrice, manualBuyAmount);
        LottoNumbersGroup lottoNumbersGroup = new LottoNumbersGroup(buyAmount, getManualLottoNumbers(buyAmount));

        showBuyStats(buyAmount, lottoNumbersGroup);

        String prizeLottoNumbersText = inputPrizeLottoNumbers();
        LottoNumbers prizeLottoNumbers = new LottoNumbers(prizeLottoNumbersText);

        int bonusNumber = inputBonusNumber();
        LottoNumber bonusLottoNumber = new LottoNumber(bonusNumber);

        LottoResults lottoResults = lottoNumbersGroup.getLottoResults(prizeLottoNumbers, bonusLottoNumber);
        showResults(buyAmount, lottoResults);
    }

    private int inputBonusNumber() {
        LottoMessage.showAskBonusNumber();
        return Integer.parseInt(scanner.nextLine());
    }

    private int inputBuyPrice() {
        LottoMessage.showAskBuyPriceMessage();
        return Integer.parseInt(scanner.nextLine());
    }

    private void showBuyStats(BuyAmount buyAmount, LottoNumbersGroup lottoNumbersGroup) {
        LottoInputView lottoInputView = new LottoInputView(buyAmount, lottoNumbersGroup);
        lottoInputView.showBuyStats();
    }

    private String inputPrizeLottoNumbers() {
        LottoMessage.showAskPrizeLottoNumbersMessage();
        return scanner.nextLine();
    }

    private void showResults(BuyAmount buyAmount, LottoResults lottoResults) {
        LottoResultsView lottoResultsView = new LottoResultsView(buyAmount, lottoResults);
        lottoResultsView.showResults();
    }


}
