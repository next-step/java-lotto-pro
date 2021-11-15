package lotto;

import java.util.ArrayList;
import java.util.List;

import lotto.domain.Ball;
import lotto.domain.Money;
import lotto.domain.Ranks;
import lotto.domain.Ticket;
import lotto.domain.TicketCount;
import lotto.domain.Tickets;
import lotto.domain.WinnerBall;
import lotto.exception.LottoErrorCode;
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
        TicketCount manualTicketCount = getManualCount(totalTicketCount);
        Tickets manualTickets = getManualTickets(manualTicketCount);

        TicketCount autoTicketCount = totalTicketCount.minus(manualTicketCount);

        Tickets autoTickets = TicketFactory.createRandomTickets(autoTicketCount);
        Tickets tickets = Tickets.combineTickets(manualTickets, autoTickets);
        ResultView.printNumberOfPurchasedLotto(manualTicketCount.getCount(), autoTicketCount.getCount());

        return tickets;
    }

    private TicketCount getManualCount(TicketCount totalTicketCount) {
        ResultView.printAskManualCount();
        try {
            TicketCount manualTicketCount = InputView.readCount();
            checkManualCountIsSmallerThanTotalCount(manualTicketCount, totalTicketCount);
            return manualTicketCount;
        } catch (LottoException lottoException) {
            ResultView.printErrorMessage(lottoException);
            return getManualCount(totalTicketCount);
        }
    }

    private void checkManualCountIsSmallerThanTotalCount(TicketCount manualTicketCount, TicketCount totalTicketCount) {
        if (manualTicketCount.isBiggerThan(totalTicketCount)) {
            throw new LottoException(LottoErrorCode.INVALID_MANUAL_COUNT);
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
