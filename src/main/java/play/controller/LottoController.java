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
        PrizeNumbers winningLotto = prizeNumbers();
        generateLottoResult(lottos, winningLotto);
    }

    private Lottos payToCounter() {
        Calculator calculator = new Calculator(InputView.inputMoneyPurchaseLotto());
        Lottos lottos = calculator.getLottos();
        OutputView.printCompletePurchaseLotto(lottos);
        return lottos;
    }

    private PrizeNumbers prizeNumbers() {
        return new PrizeNumbers(InputView.inputWinningLottoNumber());
    }

    private void generateLottoResult(Lottos lottoList, PrizeNumbers winningLotto) {
        OutputView.printResultHead();
        LottoResult lottoResult = new LottoResult(lottoList, winningLotto);
        OutputView.printLottoResult(lottoResult);
    }
}
