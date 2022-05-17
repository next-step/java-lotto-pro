package lotto;

import lotto.ui.InputView;
import lotto.ui.ResultView;

public class LottoPlay {
    public static void main(String[] args) {
        int moneyInput = InputView.getMoneyInput();
        Lottos lottos = new Lottos(moneyInput);

        ResultView.printLottoPurchase(lottos);
        Lotto winningLottoInput = InputView.getWinningLottoInput();

        WinRanks winRanks = new WinRanks();
        int winningPrice = winRanks.winningPrice(winningLottoInput, lottos);
        ResultView.printLottoResult(lottos, winningLottoInput);
        ResultView.printProfit(moneyInput, winningPrice);
    }
}