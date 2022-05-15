package lotto;

import lotto.domain.Lotto;
import lotto.domain.Player;
import lotto.view.InputView;
import lotto.view.ResultView;

public class Application {

    public static void main(String[] args) {
        Player player = createPlayer();
        Lotto lotto = lastWeekWinnerLotto();
    }

    private static Player createPlayer() {
        Player player = new Player(InputView.userPriceInput());
        ResultView.createLotto(player);
        return player;
    }

    private static Lotto lastWeekWinnerLotto() {
        return new Lotto(InputView.winnerNumberInput());
    }



}
