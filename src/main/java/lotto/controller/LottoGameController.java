package lotto.controller;

import lotto.domain.LottoNumbers;
import lotto.domain.LottoTicketMachine;
import lotto.domain.LottoTickets;
import lotto.domain.Money;
import lotto.domain.Result;
import lotto.domain.WinningLottoTicket;
import lotto.domain.strategy.RandomGenerateStrategy;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoGameController {

    private final InputView inputView;
    private final ResultView resultView;

    private LottoGameController(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public LottoGameController() {
        this(new InputView(), new ResultView());
    }

    public void play() {
        Money money = inputView.readMoney();
        LottoTickets lottoTickets = purchasedTickets(money);
        WinningLottoTicket winningLottoTicket = winningTicket();
        Result result = Result.from(lottoTickets, winningLottoTicket);
        resultView.printResult(result);
        Money totalPrize = Money.of(result.totalPrize());
        resultView.printProfitRate(totalPrize.profitRate(money));
    }

    private LottoTickets purchasedTickets(Money money) {
        LottoTickets lottoTickets = getLottoTickets(money);
        resultView.printLottoTickets(lottoTickets);
        return lottoTickets;
    }

    private WinningLottoTicket winningTicket() {
        LottoNumbers lottoNumbers = inputView.readWinningNumbers();
        return WinningLottoTicket.of(lottoNumbers);
    }

    private LottoTickets getLottoTickets(Money money) {
        LottoTicketMachine lottoTicketMachine = new LottoTicketMachine(new RandomGenerateStrategy());
        return lottoTicketMachine.buyLottoTickets(money);
    }

}
