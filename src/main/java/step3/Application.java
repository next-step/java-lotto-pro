package step3;

import step3.controller.LottoController;
import step3.domain.LottoStore;
import step3.io.InputView;
import step3.io.OutputView;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        LottoStore lottoStore = new LottoStore();

        LottoController controller = new LottoController(inputView, outputView, lottoStore);
        controller.start();
    }
}
