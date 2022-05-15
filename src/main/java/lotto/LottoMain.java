package lotto;

import lotto.factory.LottoNumbersFactory;
import lotto.game.LottoGame;
import lotto.ui.ConsoleInputView;
import lotto.ui.ConsoleResultView;

public class LottoMain {
    public static void main(String[] args) {
        LottoGame game = new LottoGame(new LottoNumbersFactory(), new ConsoleInputView(),
                new ConsoleResultView());
        game.start();
    }
}
