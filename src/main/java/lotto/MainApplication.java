package lotto;

import lotto.controller.LottoController;

public class MainApplication {
    public static void main(String[] args) {
        final LottoController lottoController = new LottoController();
        lottoController.run();
    }
}
