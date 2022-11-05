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

        int manualLottoCnt = InputView.inputManualLottoCount();
        Lottos manualLottos = LottoUtil.buy(InputView.inputManualLottoNumbers(manualLottoCnt));
        Money change = money.pay(LottoUtil.calculateTotalPrice(manualLottos.getHasLottoSize()));
        Lottos purchasedLottos = LottoGenerator.createLottos(LottoUtil.buy(change));

        OutputView.printLottosCount(manualLottos.getHasLottoSize(),
            purchasedLottos.getHasLottoSize());
        Lottos lottos = manualLottos.merge(purchasedLottos);
        OutputView.showPurchasedLottos(lottos);

        LottoNumbers winningNumbers = new LottoNumbers(InputView.inputWinningNumber());
        LottoNumber bonusNumber = new LottoNumber(InputView.inputBonusNumber());

        Rewards rewards = lottos.check(winningNumbers, bonusNumber);
        OutputView.showResults(rewards);
        OutputView.showProfitRate(rewards);

    }
}
