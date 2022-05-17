package lotto.controller;

import java.util.List;
import lotto.model.factory.LottoFactory;
import lotto.model.money.Money;
import lotto.model.lotto.Lotto;
import lotto.model.purchase.PurchaseLotto;
import lotto.model.result.LottoResult;
import lotto.model.winning.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoMachine {

    public void start() {
        Money purchasedMoney = new Money(InputView.inputPurchasedMoney());

        List<Lotto> lottoList = LottoFactory.create().generateAuto(purchasedMoney.possiblePurchaseLotto());
        OutputView.OutputPurchaseResult(purchasedMoney.possiblePurchaseLotto(), lottoList);

        PurchaseLotto purchaseLotto = new PurchaseLotto(lottoList);
        int bonusNumber = 7;
        WinningLotto winningLotto = new WinningLotto(inputLottoNumberArr(InputView.inputWinningNumber()), bonusNumber);

        LottoResult lottoResult = purchaseLotto.rankMatch(winningLotto);
        OutputView.OutputLottoResult(lottoResult, lottoResult.winningRate(purchasedMoney));
    }

    private String[] inputLottoNumberArr(String inputLottoNumbers) {
        return inputLottoNumbers.replace(" ", "").split(",");
    }

}
