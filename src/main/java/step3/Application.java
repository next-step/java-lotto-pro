package step3;

import step3.ui.ConsoleInputView;
import step3.ui.ConsoleResultView;

public class Application {
    public static void main(String[] args) {
        ConsoleInputView inputView = new ConsoleInputView();
        ConsoleResultView resultView = new ConsoleResultView();
        LottoController lottoController = new LottoController(inputView, resultView);
        lottoController.start();
    }
}
