package lotto.ui;

import lotto.domain.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LottoController {
    private static Scanner scanner;

    public void startGame() {
        scanner = new Scanner(System.in);
        int buyPrice = inputBuyPrice();
        int manualBuyAmount = getManualBuyAmount();
        PurchaseInfo purchaseInfo = new PurchaseInfo(buyPrice, manualBuyAmount);
        LottoNumbersGroup lottoNumbersGroup = new LottoNumbersGroup(purchaseInfo, getManualLottoNumbers(purchaseInfo));

        showBuyStats(purchaseInfo, lottoNumbersGroup);

        String prizeLottoNumbersText = inputPrizeLottoNumbers();

        int bonusNumber = inputBonusNumber();

        PrizeLottoNumbers prizeLottoNumbers = new PrizeLottoNumbers(prizeLottoNumbersText, bonusNumber);
        LottoResults lottoResults = lottoNumbersGroup.getLottoResults(prizeLottoNumbers);
        showResults(purchaseInfo, lottoResults);
    }

    private int inputBonusNumber() {
        LottoMessage.showAskBonusNumber();
        return Integer.parseInt(scanner.nextLine());
    }

    private int inputBuyPrice() {
        LottoMessage.showAskBuyPriceMessage();
        return Integer.parseInt(scanner.nextLine());
    }

    private int getManualBuyAmount() {
        LottoMessage.showAskManualBuyAmountMessage();
        return Integer.parseInt(scanner.nextLine());
    }

    private List<LottoNumbers> getManualLottoNumbers(PurchaseInfo purchaseInfo) {
        LottoMessage.showAskManualBuyLottoNumbersMessage();
        List<LottoNumbers> manualLottoNumbers = new ArrayList<>();
        for (int i = 0; i < purchaseInfo.getManualAmount(); i++) {
            String lottoNumbers = scanner.nextLine();
            manualLottoNumbers.add(new LottoNumbers(lottoNumbers));
        }

        return manualLottoNumbers;
    }

    private void showBuyStats(PurchaseInfo purchaseInfo, LottoNumbersGroup lottoNumbersGroup) {
        LottoInputView lottoInputView = new LottoInputView(purchaseInfo, lottoNumbersGroup);
        lottoInputView.showBuyStats();
    }

    private String inputPrizeLottoNumbers() {
        LottoMessage.showAskPrizeLottoNumbersMessage();
        return scanner.nextLine();
    }

    private void showResults(PurchaseInfo purchaseInfo, LottoResults lottoResults) {
        LottoResultsView lottoResultsView = new LottoResultsView(purchaseInfo, lottoResults);
        lottoResultsView.showResults();
    }


}
