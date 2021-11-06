package lotto.controller;

import lotto.domain.GameResult;
import lotto.domain.LottoTicket;
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
        Money inputMoney = new Money(inputView.inputMoney());
        LottoTickets lottoTickets = lottoService.buyLottoTickets(inputMoney);
        ResultView.printBuyResult(lottoTickets.count(), lottoTickets.toResultString());
        LottoTicket winningLottoTicket = LottoTickets.fromString(inputView.inputWinningNumber());
        GameResult gameResult = lottoService.getGameResult(lottoTickets, winningLottoTicket);
        ResultView.printGameResult(gameResult.toString());
        ResultView.printEarningRatio(inputMoney, new Money(gameResult.getPrize()));
    }
}
