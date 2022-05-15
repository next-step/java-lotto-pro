package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoReport;
import lotto.domain.Player;
import lotto.view.InputView;
import lotto.view.ResultView;

public class Application {

    public static void main(String[] args) {
        Player player = Player.buyAutoLotto(InputView.userPriceInput());
        ResultView.playerHasLotto(player);

        Lotto winnerLotto = lastWeekWinnerLotto();
        LottoReport lottoReport = player.matchWinnerLotto(winnerLotto);

        ResultView.winnerReport(lottoReport);

    }

    private static Lotto lastWeekWinnerLotto() {
        return Lotto.createCustomLotto(InputView.winnerNumberInput());
    }



}
