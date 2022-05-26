package lotto;

import lotto.ui.InputView;
import lotto.ui.ResultView;

public class LottoPlay {
    public static void main(String[] args) {
        int moneyInput = InputView.getMoneyInput();
        Lottos lottos = new Lottos(moneyInput);

        ResultView.printLottoPurchase(lottos);
        Lotto winningLottoInput = InputView.getWinningLottoInput();
        int bonusNumber = InputView.getBonusNumberInput(winningLottoInput);

        WinRanks winRanks = new WinRanks();
        int winningPrice = winRanks.winningPrice(winningLottoInput, lottos, bonusNumber);
        ResultView.printLottoResult(lottos, winningLottoInput);
        String profitRate = winRanks.calulateProfitRate(winningPrice, moneyInput);
        ResultView.printProfit(profitRate);
    }
}