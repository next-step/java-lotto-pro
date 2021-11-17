package lotto;

import java.util.ArrayList;
import java.util.List;

import lotto.domain.Ball;
import lotto.domain.Money;
import lotto.domain.Ranks;
import lotto.domain.Ticket;
import lotto.domain.TicketCount;
import lotto.domain.TicketCounts;
import lotto.domain.Tickets;
import lotto.domain.WinnerBall;
import lotto.exception.LottoException;
import lotto.factory.TicketFactory;
import view.InputView;
import view.ResultView;

public class LottoMachine {
    public void start() {
        Money money = getMoney();
        TicketCount totalTicketCount = money.calculateCount();

        Tickets tickets = getTickets(totalTicketCount);
        ResultView.printTickets(tickets);

        ResultView.printAskWinnerTicket();
        Ticket winnerTicket = getTicket();
        WinnerBall winnerBall = getWinnerBall(winnerTicket);

        Ranks ranks = winnerBall.calculateRank(tickets);
        ResultView.printWinningStatistics(ranks.makeStatistics());
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

    private Tickets getTickets(TicketCount totalTicketCount) {
        TicketCounts ticketCounts = getTicketCounts(totalTicketCount);

        Tickets manualTickets = getManualTickets(ticketCounts.getManualCount());
        Tickets autoTickets = TicketFactory.createRandomTickets(ticketCounts.getAutoCount());

        Tickets tickets = Tickets.combineTickets(manualTickets, autoTickets);
        ResultView.printNumberOfPurchasedLotto(ticketCounts);

        return tickets;
    }

    private TicketCounts getTicketCounts(TicketCount totalTicketCount) {
        ResultView.printAskManualCount();
        try {
            TicketCount manualCount = InputView.readCount();
            return new TicketCounts(manualCount, totalTicketCount.minus(manualCount));
        } catch (LottoException lottoException) {
            ResultView.printErrorMessage(lottoException);
            return getTicketCounts(totalTicketCount);
        }
    }

    private Tickets getManualTickets(TicketCount manualTicketCount) {
        ResultView.printAskManualTicket();
        List<Ticket> tickets = new ArrayList<>();

        for (int i = 0; manualTicketCount.isBiggerThan(i); i++) {
            tickets.add(getTicket());
        }

        return new Tickets(tickets);
    }

    private Ticket getTicket() {
        try {
            return InputView.readTicket();
        } catch (LottoException lottoException) {
            ResultView.printErrorMessage(lottoException);
            return getTicket();
        }
    }

    private WinnerBall getWinnerBall(Ticket ticket) {
        ResultView.printAskBonusNumber();

        try {
            Ball ball = InputView.readBall();
            return new WinnerBall(ticket, ball);
        } catch (LottoException lottoException) {
            ResultView.printErrorMessage(lottoException);
            return getWinnerBall(ticket);
        }

    }
}
