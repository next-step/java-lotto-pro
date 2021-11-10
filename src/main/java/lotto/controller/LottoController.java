package lotto.controller;

import lotto.domain.GameResult;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;
import lotto.domain.Money;
import lotto.service.LottoService;
import lotto.utility.ParseUtility;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {
    private final InputView inputView;
    private final ResultView resultView;
    private final LottoService lottoService;

    public LottoController(InputView inputView, ResultView resultView) {
        this.lottoService = new LottoService();
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void run() {
        // 로또 구입
        Money inputMoney = new Money(inputView.inputMoney());
        LottoTickets lottoTickets = lottoService.buyLottoTickets(inputMoney);
        resultView.printBuyResult(lottoTickets
                .toDTO());

        // 당첨번호 입력
        LottoTicket winningLottoTicket = ParseUtility.StringToLottoTicket(inputView
                .inputWinningNumber());

        // 결과 출력
        GameResult gameResult = lottoService.getGameResult(lottoTickets, winningLottoTicket);
        resultView.printGameResult(gameResult);
        resultView.printEarningRatio(inputMoney.toDTO(),
                new Money(gameResult.getPrize()).toDTO());
    }
}
