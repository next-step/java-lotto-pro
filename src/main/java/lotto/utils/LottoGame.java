package lotto.utils;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGame {
    public void start() {
        int amount = InputView.printRequestAmount();
        TotalLotto totalLotto = TotalLotto.from(amount);
        OutputView.printQuantity(totalLotto);

        Lotto lotto = LottoFactory.manualGenerator(InputView.printRequestWinningLotto());
        LottoNumber lottoNumber = LottoNumber.from(InputView.printRequestBonusNumber());
        WinningLotto winningLotto = WinningLotto.of(lotto, lottoNumber);
        LottoScore lottoScore = totalLotto.getLottoScore(winningLotto);

        OutputView.printLottoStatistic(lottoScore.getLottoScore());
        OutputView.printProfit(lottoScore.calculatorProfit(amount));
    }
}
