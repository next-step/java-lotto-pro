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
import view.OutputView;

public class LottoMachine {
    public void start() {
        Money money = getMoney();
        TicketCount totalTicketCount = money.calculateCount();

        Tickets tickets = getTickets(totalTicketCount);
        OutputView.printTickets(tickets);

        OutputView.printAskWinnerTicket();
        Ticket winnerTicket = getTicket();
        WinnerBall winnerBall = getWinnerBall(winnerTicket);

        Ranks ranks = winnerBall.calculateRank(tickets);
        OutputView.printWinningStatistics(ranks.makeStatistics());
    }

    private Money getMoney() {
        OutputView.printAskPurchaseAmount();
        try {
            return InputView.readMoney();
        } catch (LottoException lottoException) {
            OutputView.printErrorMessage(lottoException);
            return getMoney();
        }
    }

    private Tickets getTickets(TicketCount totalTicketCount) {
        TicketCounts ticketCounts = getTicketCounts(totalTicketCount);
        Tickets manualTickets = getManualTickets(ticketCounts.getManualCount());

        Tickets autoTickets = TicketFactory.createRandomTickets(ticketCounts.getAutoCount());
        Tickets tickets = Tickets.combineTickets(manualTickets, autoTickets);
        OutputView.printNumberOfPurchasedLotto(ticketCounts);

        return tickets;
    }

    private TicketCounts getTicketCounts(TicketCount totalTicketCount) {
        OutputView.printAskManualCount();
        try {
            TicketCount manualCount = InputView.readCount();
            return new TicketCounts(manualCount, totalTicketCount.minus(manualCount));
        } catch (LottoException lottoException) {
            OutputView.printErrorMessage(lottoException);
            return getTicketCounts(totalTicketCount);
        }
    }

    private Tickets getManualTickets(TicketCount manualTicketCount) {
        OutputView.printAskManualTicket();
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
            OutputView.printErrorMessage(lottoException);
            return getTicket();
        }
    }

    private WinnerBall getWinnerBall(Ticket ticket) {
        OutputView.printAskBonusNumber();

        try {
            Ball ball = InputView.readBall();
            return new WinnerBall(ticket, ball);
        } catch (LottoException lottoException) {
            OutputView.printErrorMessage(lottoException);
            return getWinnerBall(ticket);
        }

    }
}
