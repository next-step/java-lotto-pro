package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
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
            purchaseManualCount = new PurchaseManualCount(InputView.inputPurchaseManualCount(), purchasedMoney);
        } catch (IllegalArgumentException exception) {
            OutputView.OutputExceptionMessage(exception);
            purchaseManualCount = inputPurchaseManualCount(purchasedMoney);
        }

        return purchaseManualCount;
    }

    private Money inputPurchasePrice() {
        Money purchasedMoney;
        try {
            purchasedMoney = new Money(InputView.inputPurchasedMoney());
        } catch (IllegalArgumentException exception) {
            OutputView.OutputExceptionMessage(exception);
            purchasedMoney = inputPurchasePrice();
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
                .forEach(value -> lottoList.add(Lotto.fromInteger(InputView.inputEmptyAsk())));
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
            Set<Integer> lottoNumberSet = InputView.inputWinningNumber();
            int inputBonusNumber = InputView.inputBonusNumber();
            winningLotto = new WinningLotto(lottoNumberSet, inputBonusNumber);
        } catch (IllegalArgumentException exception) {
            OutputView.OutputExceptionMessage(exception);
            winningLotto = inputWinningLotto();
        }

        return winningLotto;
    }

    private void outputResult(Money purchasedMoney, PurchaseLotto purchaseLotto, WinningLotto winningLotto) {
        LottoResult lottoResult = purchaseLotto.rankMatch(winningLotto, purchasedMoney);
        OutputView.OutputLottoResult(lottoResult);
    }

}
