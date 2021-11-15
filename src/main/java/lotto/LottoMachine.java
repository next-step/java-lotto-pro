package lotto;

import lotto.domain.Ball;
import lotto.domain.Count;
import lotto.domain.Money;
import lotto.domain.Ticket;
import lotto.domain.Tickets;
import lotto.domain.WinnerBall;
import lotto.exception.LottoException;
import lotto.factory.TicketFactory;
import view.InputView;
import view.ResultView;

public class LottoMachine {
    public void start() {
        Money money = getMoney();

        Count count = money.calculateCount();
        ResultView.printNumberOfPurchasedLotto(count.getCount());

        Tickets tickets = TicketFactory.createRandomTickets(count);
        ResultView.printTickets(tickets);

        Ticket winnerTicket = getTicket();
        WinnerBall winnerBall = getWinnerTicket(winnerTicket);

        ResultView.printWinningStatistics(winnerBall.calculateRank(tickets).makeStatistics());
    }

    private Money getMoney() {
        ResultView.printAskPurchaseAmount();
        try {
            return InputView.readMoney();
        } catch (LottoException lottoException) {
            ResultView.printErrorMessage(lottoException);
            return getMoney();
        }
    }

    private Ticket getTicket() {
        ResultView.printAskWinnerTicket();
        try {
            return InputView.readTicket();
        } catch (LottoException lottoException) {
            ResultView.printErrorMessage(lottoException);
            return getTicket();
        }
    }

    private WinnerBall getWinnerTicket(Ticket ticket) {
        ResultView.printAskBonusNumber();

        try {
            Ball ball = InputView.readBall();
            return new WinnerBall(ticket, ball);
        } catch (LottoException lottoException) {
            ResultView.printErrorMessage(lottoException);
            return getWinnerTicket(ticket);
        }

    }
}
