package lotto;

import lotto.factory.NormalLottoNumbersFactory;
import lotto.game.LottoGame;
import lotto.ui.ConsoleInputView;
import lotto.ui.ConsoleResultView;

public class LottoMain {
    public static void main(String[] args) {
        LottoGame game = new LottoGame(new NormalLottoNumbersFactory(),new ConsoleInputView(),new ConsoleResultView());
        game.start();
    }
}
