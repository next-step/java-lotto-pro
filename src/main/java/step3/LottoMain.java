package step3;

import step3.component.GameStatusChangeable;
import step3.component.GameStatusManager;
import step3.component.LottoGeneratorable;
import step3.component.LottoShuffleable;
import step3.component.SimpleLottoShuffler;
import step3.component.StringSplitLottoGenerator;
import step3.view.ConsoleInputView;
import step3.view.ConsoleOutputView;

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
