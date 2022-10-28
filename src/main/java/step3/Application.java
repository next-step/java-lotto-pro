package step3;

import step3.ui.InputView;
import step3.ui.ResultView;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController(new InputView(), new ResultView());
        lottoController.start();
    }
}
