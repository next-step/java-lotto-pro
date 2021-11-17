package lotto;

import lotto.component.GameStatusChangeable;
import lotto.component.GameStatusManager;
import lotto.component.LottoGeneratorable;
import lotto.component.LottoShuffleable;
import lotto.component.SimpleLottoShuffler;
import lotto.component.StringSplitLottoGenerator;
import lotto.view.ConsoleInputView;
import lotto.view.ConsoleOutputView;

public class LottoMain {

    public static void main(String[] args) {
        final LottoGeneratorable lottoGeneratorable = new StringSplitLottoGenerator();
        final LottoShuffleable lottoShuffleable = new SimpleLottoShuffler();
        final GameStatusChangeable gameStatusManager = new GameStatusManager();
        final ConsoleInputView consoleInputView = new ConsoleInputView();
        final ConsoleOutputView consoleOutputView = new ConsoleOutputView();

        final LottoGame lottoGame =
            new LottoGame(lottoGeneratorable, lottoShuffleable, gameStatusManager, consoleInputView, consoleOutputView);
        lottoGame.start();
    }
}
