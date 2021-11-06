package lotto.controller;

import lotto.domain.LottoTickets;
import lotto.domain.Money;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {
    InputView inputView;
    ResultView resultView;
    LottoService lottoService;

    public LottoController(InputView inputView, ResultView resultView) {
        this.lottoService = new LottoService();
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void run() {
        Money money = new Money(inputView.inputMoney());
        LottoTickets lottoTickets = lottoService.buyLottoTickets(money);
        ResultView.printBuyResult(lottoTickets.count(), lottoTickets.toResultString());
    }
}
