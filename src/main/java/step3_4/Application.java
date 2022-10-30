package step3_4;

import step3_4.controller.LottoController;
import step3_4.domain.LottoStore;
import step3_4.io.InputView;
import step3_4.io.OutputView;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        LottoStore lottoStore = new LottoStore();

        LottoController controller = new LottoController(inputView, outputView, lottoStore);
        controller.start();
    }
}
