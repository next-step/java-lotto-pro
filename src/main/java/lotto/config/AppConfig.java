package lotto.config;

import java.util.Arrays;
import java.util.List;
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

    public static List<Runnable> withBonus() {
        return Arrays.asList(
                () -> lottoGame().createWinningNumber(lottoView().readWinningNumber()),
                () -> lottoGame().createLottoNumberMatcherWithBonus(lottoView().readBonus()));
    }

    public static List<Runnable> withOutBonus() {
        return Arrays.asList(
                () -> lottoGame().createWinningNumber(lottoView().readWinningNumber()),
                () -> lottoGame().createLottoNumberMatcher());
    }

    private static LottoView lottoView() {
        return lottoView;
    }

    private static LottoGame lottoGame() {
        return lottoGame;
    }
}

