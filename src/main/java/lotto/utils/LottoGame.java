package lotto.utils;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGame {
    public void start() {
        int amount = InputView.getAmountPrint();
        Money money = Money.from(amount);
        Lottos lottos = LottoShop.generateLottos(money.getCount());
        TotalLotto totalLotto = TotalLotto.of(money, lottos);
        OutputView.printQuantity(totalLotto);

        Lotto lotto = LottoFactory.manualGenerator(InputView.getWinningLottoPrint());
        LottoNumber lottoNumber = LottoNumber.from(InputView.getBonusNumberPrint());
        WinningLotto winningLotto = WinningLotto.of(lotto, lottoNumber);
        LottoScore lottoScore = totalLotto.getLottoScore(winningLotto);

        OutputView.printLottoStatistic(lottoScore.getLottoScore());
        OutputView.printProfit(lottoScore.calculatorProfit(amount));
    }
}
