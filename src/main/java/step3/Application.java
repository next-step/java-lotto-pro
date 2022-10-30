package step3;

import step3.ui.ConsoleInputView;
import step3.ui.ConsoleResultView;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController(new ConsoleInputView(), new ConsoleResultView());
        lottoController.start();
    }
}
