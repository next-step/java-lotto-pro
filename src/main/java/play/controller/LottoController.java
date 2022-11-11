package play.controller;

import play.domain.Calculator;
import play.domain.LottoResult;
import play.domain.Lottos;
import play.domain.PrizeNumbers;
import play.ui.InputView;
import play.ui.OutputView;

public class LottoController {
    public void lotto() {
        generateLotto();
    }

    private void generateLotto() {
        Lottos lottos = payToCounter();
        PrizeNumbers winningLotto = getPrizeNumbers();
        generateLottoResult(lottos, winningLotto);
    }

    private Lottos payToCounter() {
        Calculator calculator = new Calculator();
        Lottos lottos = calculator.buyLotto(InputView.inputMoneyPurchaseLotto());
        OutputView.printCompletePurchaseLotto(lottos);
        return lottos;
    }

    private PrizeNumbers getPrizeNumbers() {
        return new PrizeNumbers(InputView.inputWinningLottoNumber());
    }

    private void generateLottoResult(Lottos lottoList, PrizeNumbers winningLotto) {
        OutputView.printResultHead();
        LottoResult lottoResult = new LottoResult();
        lottoResult.calculateLottoResult(lottoList, winningLotto);
        OutputView.printLottoResult(lottoResult);
    }
}
