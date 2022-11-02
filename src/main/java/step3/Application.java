package step3;

import step3.controller.LottoController;
import step3.domain.LottoStore;

public class Application {

    public static void main(String[] args) {
        LottoStore lottoStore = new LottoStore();
        LottoController controller = new LottoController(lottoStore);
        controller.start();
    }
}
