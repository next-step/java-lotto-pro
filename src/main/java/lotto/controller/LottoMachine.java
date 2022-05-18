package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import lotto.model.factory.LottoFactory;
import lotto.model.lotto.Lotto;
import lotto.model.money.Money;
import lotto.model.purchase.PurchaseLotto;
import lotto.model.purchase.PurchaseManualCount;
import lotto.model.result.LottoResult;
import lotto.model.winning.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoMachine {

    public void start() {
        Money purchasedMoney = inputPurchasePrice();

        PurchaseManualCount purchaseManualCount = inputPurchaseManualCount(purchasedMoney);

        PurchaseLotto purchaseLotto = purchaseLotto(purchasedMoney, purchaseManualCount);

        WinningLotto winningLotto = inputWinningLotto();
        outputResult(purchasedMoney, purchaseLotto, winningLotto);
    }

    private PurchaseManualCount inputPurchaseManualCount(Money purchasedMoney) {
        PurchaseManualCount purchaseManualCount;
        try {
            String inputPurchaseManualCount = InputView.inputPurchaseManualCount();
            purchaseManualCount = new PurchaseManualCount(inputPurchaseManualCount, purchasedMoney);
        } catch (IllegalArgumentException exception) {
            OutputView.OutputExceptionMessage(exception);
            inputPurchaseManualCount(purchasedMoney);
            return null;
        }
        return purchaseManualCount;
    }

    private Money inputPurchasePrice() {
        Money purchasedMoney;
        try {
            purchasedMoney = new Money(InputView.inputPurchasedMoney());
        } catch (IllegalArgumentException exception) {
            OutputView.OutputExceptionMessage(exception);
            inputPurchasePrice();
            return null;
        }
        return purchasedMoney;
    }

    private PurchaseLotto purchaseLotto(Money purchasedMoney, PurchaseManualCount purchaseManualCount) {
        List<Lotto> manualLottoList = inputPurchaseManualLotto(purchaseManualCount);
        List<Lotto> autoLottoList = LottoFactory.create().generateAuto(purchasedMoney.possiblePurchaseLotto());

        PurchaseLotto purchaseLotto = new PurchaseLotto(autoLottoList, manualLottoList);
        OutputView.OutputPurchaseResult(purchaseLotto);

        return purchaseLotto;
    }

    private List<Lotto> inputPurchaseManualLotto(PurchaseManualCount purchaseManualCount) {
        List<Lotto> lottoList = new ArrayList<>();

        try {
            InputView.inputPurchaseManualLotto();
            IntStream.rangeClosed(1, purchaseManualCount.getPurchaseManualCount())
                .forEach(value -> lottoList.add(Lotto.of(inputLottoNumberArr(InputView.inputEmptyAsk()))));
        } catch (IllegalArgumentException exception) {
            OutputView.OutputExceptionMessage(exception);
            inputPurchaseManualLotto(purchaseManualCount);
            return null;
        }

        return lottoList;
    }

    private WinningLotto inputWinningLotto() {
        WinningLotto winningLotto;
        try {
            String[] lottoNumberArr = inputLottoNumberArr(InputView.inputWinningNumber());
            String inputBonusNumber = InputView.inputBonusNumber();
            winningLotto = new WinningLotto(lottoNumberArr, inputBonusNumber);
        } catch (IllegalArgumentException exception) {
            OutputView.OutputExceptionMessage(exception);
            inputWinningLotto();
            return null;
        }

        return winningLotto;
    }

    private void outputResult(Money purchasedMoney, PurchaseLotto purchaseLotto, WinningLotto winningLotto) {
        LottoResult lottoResult = purchaseLotto.rankMatch(winningLotto, purchasedMoney);
        OutputView.OutputLottoResult(lottoResult);
    }

    private String[] inputLottoNumberArr(String inputLottoNumbers) {;
        return inputLottoNumbers.replace(" ", "").split(",");
    }

}
