package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {

    private final LottoMachine lottoMachine;

    public LottoController() {
        this.lottoMachine = new LottoMachine();
    }

    public Lottos buy() {
        Money purchaseAmount = Money.of(InputView.inputPurchaseAmount());
        Lottos buy = lottoMachine.buy(purchaseAmount);

        ResultView.printPurchaseCount(buy);
        ResultView.printLottos(buy);

        return buy;
    }

    public WinningStatistic checkWinning(Lottos buy) {
        String winningNumbers = InputView.inputWinningNumbers();
        String bonusBall = InputView.inputBonusBall();

        WinningLotto winnings = new WinningLotto(winningNumbers, bonusBall);
        return buy.checkWinnings(winnings);
    }

    public void printResult(WinningStatistic winningStatistic, Money purchaseAmount) {
        ResultView.printWinningStatistic(winningStatistic);
        ResultView.printRateOfReturn(winningStatistic, purchaseAmount);
    }
}
