package lotto.controller;

import lotto.domain.Money;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {
    InputView inputView;
    ResultView resultView;
    LottoService lottoService;

    public LottoController(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
        this.lottoService = new LottoService();
    }

    public void run() {
        Money money = new Money(inputView.inputMoney());
        lottoService.buyLotto(money);
    }
}
