package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoConst;
import lotto.domain.LottoNo;
import lotto.domain.Lottos;
import lotto.domain.WinRanks;
import lotto.ui.InputView;
import lotto.ui.ResultView;

public class LottoPlay {
    public static void main(String[] args) {
        lottoPlay();
    }

    private static void lottoPlay() {
        int moneyInput = InputView.getMoneyInput();
        Lottos manualLottos = createManualLottos(moneyInput);
        Lottos userLottos = createAutoLottos(manualLottos, moneyInput);
        int autoCount = userLottos.getLottosSize() - manualLottos.getLottosSize();

        ResultView.printLottoPurchase(userLottos, manualLottos.getLottosSize(), autoCount);

        Lotto winningLottoInput = InputView.getWinningLottoInput();
        LottoNo bonusNumber = InputView.getBonusNumberInput(winningLottoInput);

        printResult(userLottos, winningLottoInput, bonusNumber, moneyInput);
    }

    private static Lottos createManualLottos(int moneyInput) {
        int manualCount = InputView.getManualCount(moneyInput);
        Lottos manualLottos = InputView.getManualLottosInput(manualCount);
        return manualLottos;
    }

    private static Lottos createAutoLottos(Lottos manualLottos, int moneyInput) {
        int manualCount = manualLottos.getLottosSize();
        int autoCount = moneyInput / Lotto.LOTTO_PRICE - manualCount;
        Lottos lottos = new Lottos(autoCount);
        lottos.mergeLottos(manualLottos);
        return lottos;
    }

    private static void printResult(Lottos userLottos, Lotto winningLottoInput, LottoNo bonusNumber, int moneyInput) {
        WinRanks winRanks = new WinRanks();
        int winningPrice = winRanks.winningPrice(winningLottoInput, userLottos, bonusNumber);

        ResultView.printLottoResult(userLottos, winningLottoInput, winRanks);
        double profitRate = winRanks.calulateProfitRate(winningPrice, moneyInput);

        ResultView.printProfit(profitRate);
    }
}