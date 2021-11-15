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
        ResultView.printNumberOfPurchasedLotto(totalTicketCount.getCount());

        TicketCount manualTicketCount = getManualCount(totalTicketCount);
        Tickets manualTickets = getManualTickets(manualTicketCount);

        Tickets tickets = TicketFactory.createRandomTickets(totalTicketCount);
        ResultView.printTickets(tickets);

        ResultView.printAskWinnerTicket();
        Ticket winnerTicket = getTicket();
        WinnerBall winnerBall = getWinnerTicket(winnerTicket);

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
