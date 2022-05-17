package lotto.controller;

import java.util.List;
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

        List<Lotto> lottoList = lottoAutoGenerate(purchasedMoney);

        PurchaseLotto purchaseLotto = new PurchaseLotto(lottoList);

        WinningLotto winningLotto = inputWinningLotto();
        outputResult(purchasedMoney, purchaseLotto, winningLotto);
    }

    private List<Lotto> lottoAutoGenerate(Money purchasedMoney) {
        List<Lotto> lottoList = LottoFactory.create().generateAuto(purchasedMoney.possiblePurchaseLotto());
        OutputView.OutputPurchaseResult(purchasedMoney.possiblePurchaseLotto(), lottoList);
        return lottoList;
    }

    private WinningLotto inputWinningLotto() {
        String[] lottoNumberArr = inputLottoNumberArr(InputView.inputWinningNumber());
        String inputBonusNumber = InputView.inputBonusNumber();
        return new WinningLotto(lottoNumberArr, inputBonusNumber);
    }

    private void outputResult(Money purchasedMoney, PurchaseLotto purchaseLotto, WinningLotto winningLotto) {
        LottoResult lottoResult = purchaseLotto.rankMatch(winningLotto);
        OutputView.OutputLottoResult(lottoResult, lottoResult.winningRate(purchasedMoney));
    }

    private String[] inputLottoNumberArr(String inputLottoNumbers) {
        return inputLottoNumbers.replace(" ", "").split(",");
    }

}
