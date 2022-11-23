package lotto2;

import lotto2.controller.LottoController;
import lotto2.view.LottoView;

public class MainApplication {
    public static void main(String[] args) {
        final LottoView lottoView = new LottoView();
        final LottoController lottoController = new LottoController(lottoView);
        lottoController.run();
    }
}
