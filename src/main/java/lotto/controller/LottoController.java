package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {

    public Lottos buy() {
        Money purchaseAmount = Money.of(InputView.inputPurchaseAmount());
        Lottos buy = LottoMachine.buy(purchaseAmount);

        ResultView.printPurchaseCount(buy);
        ResultView.printLottos(buy);

        return buy;
    }

    public WinningStatistic checkWinning(Lottos buy) {
        String winningNumbers = InputView.inputWinningNumbers();

        Lotto winnings = Lotto.createWithNumberLetter(winningNumbers);
        return buy.checkWinnings(winnings);
    }

    public void printResult(WinningStatistic winningStatistic, Money purchaseAmount) {
        ResultView.printWinningStatistic(winningStatistic);
        ResultView.printRateOfReturn(winningStatistic, purchaseAmount);
    }
}
