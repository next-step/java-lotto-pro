package step3;

import step3.controller.LottoController;
import step3.service.LottoServiceImpl;

public class LottoApplication {

    public static void main(String[] args) {
        LottoController lottoController = new LottoController();
        lottoController.play(lottoController);
    }
}
