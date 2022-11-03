package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.domain.Result;
import lotto.domain.ticket.Ticket;
import lotto.domain.ticket.Tickets;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private Tickets myTickets;
    private Result myResult;
    
    public void playLotto() {
        OutputView.startLottoOutput();
        
        Lotto lotto = new Lotto();
        Money money = new Money(InputView.getInput());
        this.myTickets = lotto.buyTickets(money);
        
        OutputView.printHowManyTicketsPurchased(myTickets.size());
        OutputView.print(myTickets.toString());
        OutputView.printWinningLottoNumOutput();
        
        String winningTicketNumbers = InputView.getInput();

        OutputView.printBonusNumOutput();
        
        Ticket winningTicket = new Ticket(winningTicketNumbers, InputView.getInput());
        checkResult(winningTicket, lotto.getUsedMoney());
        
        OutputView.printResultOutput(this.myResult.winningMap, this.myResult.returnRate);
    }
    
    private void checkResult(Ticket winningTicket, Money usedMoney) {
        this.myResult = new Result();
        
        this.myTickets.countTicketResult(this.myResult, winningTicket);
        this.myResult.checkResultRate(usedMoney);
    }

}
