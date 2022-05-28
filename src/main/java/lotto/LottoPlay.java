package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoConst;
import lotto.domain.LottoNo;
import lotto.domain.Lottos;
import lotto.domain.WinRanks;
import lotto.ui.InputView;
import lotto.ui.ResultView;

public class LottoPlay {
    static int moneyInput;
    static int manualCount;
    static int autoCount;
    static Lottos lottos;
    static Lotto winningLottoInput;
    static LottoNo bonusNumber;

    public static void main(String[] args) {
        lottoInput();
        printResult();
    }

    private static void lottoInput() {
        moneyInput = InputView.getMoneyInput();
        manualCount = InputView.getManualCount(moneyInput);
        Lottos manualLottos = InputView.getManualLottosInput(manualCount);

        autoCount = moneyInput / LottoConst.LOTTO_PRICE - manualCount;
        lottos = new Lottos(autoCount);
        lottos.mergeLottos(manualLottos);

        ResultView.printLottoPurchase(lottos, manualCount, autoCount);
        winningLottoInput = InputView.getWinningLottoInput();
        bonusNumber = InputView.getBonusNumberInput(winningLottoInput);
    }

    private static void printResult() {
        WinRanks winRanks = new WinRanks();
        int winningPrice = winRanks.winningPrice(winningLottoInput, lottos, bonusNumber);

        ResultView.printLottoResult(lottos, winningLottoInput, winRanks);
        double profitRate = winRanks.calulateProfitRate(winningPrice, moneyInput);

        ResultView.printProfit(profitRate);
    }
}