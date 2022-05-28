package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoNo;
import lotto.domain.Lottos;
import lotto.domain.WinRanks;
import lotto.ui.InputView;
import lotto.ui.ResultView;

public class LottoPlay {
    public static void main(String[] args) {
        int moneyInput = InputView.getMoneyInput();
        Lottos lottos = new Lottos(moneyInput);

        ResultView.printLottoPurchase(lottos);
        Lotto winningLottoInput = InputView.getWinningLottoInput();
        LottoNo bonusNumber = InputView.getBonusNumberInput(winningLottoInput);

        WinRanks winRanks = new WinRanks();
        int winningPrice = winRanks.winningPrice(winningLottoInput, lottos, bonusNumber);

        ResultView.printLottoResult(lottos, winningLottoInput, winRanks);
        double profitRate = winRanks.calulateProfitRate(winningPrice, moneyInput);

        ResultView.printProfit(profitRate);
    }
}