package step3;

import step3.component.GameStatusChangeable;
import step3.component.GameStatusManager;
import step3.component.LottoResult;
import step3.view.ConsoleInputView;
import step3.view.ConsoleOutputView;

public class LottoMain {

    public static void main(String[] args) {
        final GameStatusChangeable gameStatusManager = new GameStatusManager();
        final ConsoleInputView consoleInputView = new ConsoleInputView();
        final ConsoleOutputView consoleOutputView = new ConsoleOutputView();
        final LottoResult lottoResult = new LottoResult();

        final LottoGame lottoGame = new LottoGame(gameStatusManager, consoleInputView, consoleOutputView, lottoResult);
        lottoGame.start();
    }
}
