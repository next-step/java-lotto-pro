package lotto.config;

import lotto.controller.LottoController;
import lotto.domain.LottoGame;
import lotto.view.LottoConsoleView;
import lotto.view.LottoView;

public abstract class AppConfig {

    private static final LottoGame lottoGame = new LottoGame();
    private static final LottoView lottoView = new LottoConsoleView();

    public static LottoController lottoController() {
        return new LottoController(lottoGame(), lottoView());
    }

    public static Runnable withBonus() {
        return () -> lottoGame().createLottoNumberMatcherWithBonus(lottoView().readBonus());
    }

    public static Runnable withOutBonus() {
        return () -> lottoGame().createLottoNumberMatcher();
    }

    private static LottoView lottoView() {
        return lottoView;
    }

    private static LottoGame lottoGame() {
        return lottoGame;
    }
}

