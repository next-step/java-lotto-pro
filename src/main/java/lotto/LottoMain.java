package lotto;

import lotto.controller.LottoController;
import lotto.domain.LottoPrice;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.WinningStatistic;

public class LottoMain {

    public static void main(String[] args) {
        LottoController lottoController = new LottoController();

        Lottos buy = lottoController.buy();
        WinningStatistic winningStatistic = lottoController.checkWinning(buy);

        Money purchaseAmount = LottoPrice.calculatePurchaseAmount(buy.count());
        lottoController.printResult(winningStatistic, purchaseAmount);
    }
}
