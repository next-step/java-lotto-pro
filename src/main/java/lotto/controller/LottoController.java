package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.ticket.Ticket;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    public void playLotto() {
        OutputView.startLottoOutput();
        
        Lotto lotto = new Lotto(InputView.getInput());
        
        OutputView.printHowManyTicketsPurchased(lotto.tickets.size());
        OutputView.print(lotto.tickets.toString());
        OutputView.printWinningLottoNumOutput();
        
        String winningTicketNumbers = InputView.getInput();

        OutputView.printBonusNumOutput();
        
        Ticket winningTicket = new Ticket(winningTicketNumbers, InputView.getInput());
        lotto.checkResult(winningTicket);
        
        OutputView.printResultOutput(lotto.result.winningMap, lotto.result.returnRate);
    }

}
