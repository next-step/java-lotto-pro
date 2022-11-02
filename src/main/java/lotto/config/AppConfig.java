package lotto.config;

import lotto.controller.AutoLottoController;
import lotto.controller.BonusLottoController;
import lotto.controller.LottoController;
import lotto.controller.ManualLottoController;
import lotto.domain.LottoGame;
import lotto.view.LottoConsoleView;
import lotto.view.LottoView;

public abstract class AppConfig {

    private static final LottoGame lottoGame = new LottoGame();
    private static final LottoView lottoView = new LottoConsoleView();

    public static LottoController autoLottoController() {
        return new AutoLottoController(lottoGame(), lottoView(), withOutBonus());
    }

    public static LottoController bonusLottoController() {
        return new BonusLottoController(lottoGame(), lottoView(), withBonus());
    }

    public static LottoController manualLottoController() {
        return new ManualLottoController(lottoGame(), lottoView(), withBonus());
    }

    private static Runnable withBonus() {
        return () -> lottoGame().createLottoNumberMatcherWithBonus(lottoView().readBonus());
    }

    private static Runnable withOutBonus() {
        return () -> lottoGame().createLottoNumberMatcher();
    }

    private static LottoView lottoView() {
        return lottoView;
    }

    private static LottoGame lottoGame() {
        return lottoGame;
    }
}

