package lotto.config;

import lotto.service.LottoAutoIssuedServiceImpl;
import lotto.service.LottoIssuedService;
import lotto.view.InputView;
import lotto.view.ResultView;

public class AppConfig {
    public LottoIssuedService lottoIssuedService() {
        return new LottoAutoIssuedServiceImpl();
    }

    public InputView inputView() {
        return new InputView();
    }

    public ResultView resultView() {
        return new ResultView();
    }
}
