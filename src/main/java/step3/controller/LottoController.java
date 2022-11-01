package step3.controller;

import step3.domain.LottoGenerator;
import step3.domain.LottoNumber;
import step3.domain.LottoNumbers;
import step3.domain.LottoUtil;
import step3.domain.Lottos;
import step3.domain.Money;
import step3.domain.Rewards;
import step3.view.InputView;
import step3.view.OutputView;

public class LottoController {

    public void run() {
        Money money = new Money(InputView.inputPurchaseAmount());

        Lottos purchasedLottos = LottoGenerator.createLottos(LottoUtil.buy(money));
        OutputView.showPurchaseLottoCount(LottoUtil.buy(money));
        OutputView.showPurchasedLottos(purchasedLottos);

        LottoNumbers winningNumbers = new LottoNumbers(InputView.inputWinningNumber());
        LottoNumber bonusNumber = new LottoNumber(InputView.inputBonusNumber());

        Rewards rewards = purchasedLottos.check(winningNumbers);
        OutputView.showResults(rewards);
        OutputView.showProfitRate(rewards);

    }

}
