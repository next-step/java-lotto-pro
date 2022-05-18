package lotto;

import lotto.controller.LottoController;
import lotto.view.View;

public class Application {

    public static void main(String[] args) {
        LottoController controller = new LottoController(new View());
        controller.start();
    }
}
