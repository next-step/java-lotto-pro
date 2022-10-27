package lotto.controller;

import java.util.List;

import lotto.domain.LottoNumbers;
import lotto.domain.LottoTicketMachine;
import lotto.domain.LottoTickets;
import lotto.domain.Money;
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
        LottoTicketMachine lottoTicketMachine = new LottoTicketMachine(new RandomGenerateStrategy());
        LottoTickets lottoTickets = lottoTicketMachine.buyLottoTickets(money);
        resultView.printLottoTickets(lottoTickets);
        LottoNumbers lottoNumbers = inputView.readWinningNumbers();
        WinningLottoTicket winningLottoTicket = WinningLottoTicket.of(lottoNumbers);
        System.out.println("winningLottoTicket = " + winningLottoTicket);
        List<Integer> match = lottoTickets.match(winningLottoTicket);
        System.out.println("match = " + match);

    }

}
