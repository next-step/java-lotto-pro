package step3.controller;

import step3.domain.LottoGenerator;
import step3.domain.LottoNumbers;
import step3.domain.LottoShop;
import step3.domain.Lottos;
import step3.domain.Money;
import step3.domain.Rewards;
import step3.view.InputView;
import step3.view.OutputView;

public class LottoController {

    public void run() {
        Money money = new Money(InputView.inputPurchaseAmount());

        Lottos purchasedLottos = LottoGenerator.createLottos(new LottoShop().buy(money));
        OutputView.showPurchaseLottoCount(new LottoShop().buy(money));
        OutputView.showPurchasedLottos(purchasedLottos);

        LottoNumbers winningNumbers = new LottoNumbers(InputView.inputWinningNumber());

        Rewards rewards = purchasedLottos.check(winningNumbers);
        OutputView.showResults(rewards);
        OutputView.showProfitRate(rewards);

    }

}
