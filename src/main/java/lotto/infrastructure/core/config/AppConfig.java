package lotto.infrastructure.core.config;

import lotto.application.service.LottoService;
import lotto.infrastructure.generator.LottoNumberGenerator;
import lotto.infrastructure.generator.NumberGenerator;
import lotto.interfaces.controller.LottoController;
import lotto.view.InputView;
import lotto.view.ResultView;

public class AppConfig {

    public NumberGenerator lottoNumberGenerator() {
        return new LottoNumberGenerator();
    }

    public InputView inputView() {
        return new InputView();
    }

    public ResultView resultView() {
        return new ResultView();
    }

    public LottoService lottoService() {
        return new LottoService(lottoNumberGenerator());
    }

    public LottoController lottoController() {
        return new LottoController(lottoService(), inputView(), resultView());
    }
}
