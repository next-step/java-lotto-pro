package step3.controller;

import step3.domain.Result;
import step3.domain.Lotto;
import step3.domain.LottoGenerator;
import step3.domain.LottoNumbers;
import step3.domain.Lottos;
import step3.domain.Money;
import step3.domain.Rate;
import step3.view.InputView;
import step3.view.OutputView;

public class LottoController {

    public void run() {
        Money money = new Money(InputView.inputPurchaseAmount());

        Lottos purchasedLottos = LottoGenerator.createLottos(money.calculateQuantity());
        OutputView.showPurchaseLottoCount(money.calculateQuantity());
        OutputView.showPurchasedLottos(purchasedLottos);

        Lotto winingLotto = new Lotto(new LottoNumbers(InputView.inputWinningNumber()));

        Result results = new Result(purchasedLottos, winingLotto);
        OutputView.showResults(results);

        Rate rate = new Rate(money, results.getTotalWinning());
        OutputView.showProfitRate(rate);
    }

}
