package lotto.config;

import lotto.controller.LottoController;
import lotto.domain.LottoGame;
import lotto.view.LottoConsoleView;
import lotto.view.LottoView;

public abstract class AppConfig {

    public static LottoController lottoController() {
        return new LottoController(lottoGame(), lottoView());
    }

    private static LottoView lottoView() {
        return new LottoConsoleView();
    }

    private static LottoGame lottoGame() {
        return new LottoGame();
    }
}

