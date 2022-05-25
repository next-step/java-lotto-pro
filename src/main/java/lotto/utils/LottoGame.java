package lotto.utils;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoGame {
    public void start() {
        Money money = generateMoney();
        List<String> inputManualLottoNumbers = InputView.getManualLottoNumbers(money.getManualCount());
        Lottos lottos = LottoShop.generateLottos(money, inputManualLottoNumbers);
        TotalLotto totalLotto = TotalLotto.of(money, lottos);
        OutputView.printQuantity(totalLotto);

        Lotto lotto = LottoFactory.manualGenerator(InputView.getWinningLottoPrint());
        LottoNumber lottoNumber = LottoNumber.from(InputView.getBonusNumberPrint());
        WinningLotto winningLotto = WinningLotto.of(lotto, lottoNumber);
        LottoScore lottoScore = totalLotto.getLottoScore(winningLotto);

        OutputView.printLottoStatistic(lottoScore.getLottoScore());
        OutputView.printProfit(lottoScore.calculatorProfit(money.getAmount()));
    }

    private Money generateMoney() {
        int amount = InputView.getAmountPrint();
        int manualCount = InputView.getManualCountPrint();
        return Money.of(amount, manualCount);
    }
}
