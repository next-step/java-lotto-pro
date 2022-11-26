package lotto2;

import lotto2.controller.LottoController;
import lotto2.view.InputView;
import lotto2.view.OutputView;

public class MainApplication {
    public static void main(String[] args) {
        final InputView inputView = new InputView();
        final OutputView outputView = new OutputView();
        final LottoController lottoController = new LottoController(inputView, outputView);
        lottoController.run();
    }
}
