package lotto;

import lotto.config.AppConfig;
import lotto.controller.LottoController;

public class Application {

    public static void main(String[] args) {
        LottoController lottoController = AppConfig.lottoController();
        lottoController.createLottoNumbers();
        lottoController.createLotto();
        lottoController.startLotto();
    }
}
