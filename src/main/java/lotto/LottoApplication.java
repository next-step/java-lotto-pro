package lotto;

import lotto.infrastructure.core.config.AppConfig;
import lotto.interfaces.controller.LottoController;

public class LottoApplication {

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        LottoController lottoController = appConfig.lottoController();

        lottoController.play();
    }
}
