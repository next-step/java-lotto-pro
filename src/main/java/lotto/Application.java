package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoReport;
import lotto.domain.Player;
import lotto.view.InputView;
import lotto.view.ResultView;

public class Application {

    public static void main(String[] args) {

        Player player = Player.buyAutoLotto(autoLottoDeposit());
        ResultView.playerHasLotto(player);

        Lotto winnerLotto = lastWeekWinnerLotto();
        LottoReport lottoReport = player.matchWinnerLotto(winnerLotto);

        ResultView.winnerReport(lottoReport);

    }

    private static int autoLottoDeposit() {
        int despotMoney = InputView.userPriceInput();
        if (despotMoney < Lotto.LOTTO_MONEY) {
            return InputView.retryPriceInput();
        }
        return despotMoney;
    }

    private static Lotto lastWeekWinnerLotto() {
        return Lotto.createCustomLotto(InputView.winnerNumberInput());
    }



}
