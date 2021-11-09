package step3;

import step3.view.ConsoleInputView;
import step3.view.ConsoleOutputView;

public class LottoMain {

    public static void main(String[] args) {
        final ConsoleInputView consoleInputView = new ConsoleInputView();
        final ConsoleOutputView consoleOutputView = new ConsoleOutputView();
        final LottoResult lottoResult = new LottoResult();

        final LottoGame lottoGame = new LottoGame(consoleInputView, consoleOutputView, lottoResult);
        lottoGame.start();
    }
}
