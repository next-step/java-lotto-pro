package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import lotto.model.factory.LottoFactory;
import lotto.model.lotto.Lotto;
import lotto.model.money.Money;
import lotto.model.purchase.PurchaseLotto;
import lotto.model.result.LottoResult;
import lotto.model.winning.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoMachine {

    public void start() {
        Money purchasedMoney = new Money(InputView.inputPurchasedMoney());

        String inputPurchaseManualCount = InputView.inputPurchaseManualCount();
        int purchaseManualCount = Integer.parseInt(inputPurchaseManualCount);

        PurchaseLotto purchaseLotto = purchaseLotto(purchasedMoney, purchaseManualCount);

        WinningLotto winningLotto = inputWinningLotto();
        outputResult(purchasedMoney, purchaseLotto, winningLotto);
    }

    private PurchaseLotto purchaseLotto(Money purchasedMoney, int purchaseManualCount) {
        List<Lotto> manualLottoList = inputPurchaseManualLotto(purchaseManualCount);
        List<Lotto> autoLottoList = LottoFactory.create().generateAuto(purchasedMoney.possiblePurchaseLotto());

        PurchaseLotto purchaseLotto = new PurchaseLotto(autoLottoList, manualLottoList);
        OutputView.OutputPurchaseResult(purchaseLotto);

        return purchaseLotto;
    }

    private List<Lotto> inputPurchaseManualLotto(int inputPurchaseManualCount) {
        List<Lotto> lottoList = new ArrayList<>();

        InputView.inputPurchaseManualLotto();
        IntStream.rangeClosed(1, inputPurchaseManualCount)
            .forEach(value -> lottoList.add(Lotto.of(inputLottoNumberArr(InputView.inputEmptyAsk()))));

        return lottoList;
    }

    private WinningLotto inputWinningLotto() {
        String[] lottoNumberArr = inputLottoNumberArr(InputView.inputWinningNumber());
        String inputBonusNumber = InputView.inputBonusNumber();
        return new WinningLotto(lottoNumberArr, inputBonusNumber);
    }

    private void outputResult(Money purchasedMoney, PurchaseLotto purchaseLotto, WinningLotto winningLotto) {
        LottoResult lottoResult = purchaseLotto.rankMatch(winningLotto, purchasedMoney);
        OutputView.OutputLottoResult(lottoResult);
    }

    private String[] inputLottoNumberArr(String inputLottoNumbers) {
        return inputLottoNumbers.replace(" ", "").split(",");
    }

}
