package lotto;

import lotto.domain.Ball;
import lotto.domain.Count;
import lotto.domain.Money;
import lotto.domain.Ranks;
import lotto.domain.Ticket;
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

        Count totalCount = money.calculateCount();
        ResultView.printNumberOfPurchasedLotto(totalCount.getCount());

        Count manualCount = getManualCount(totalCount);

        Tickets tickets = TicketFactory.createRandomTickets(totalCount);
        ResultView.printTickets(tickets);

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

    private Count getManualCount(Count totalCount) {
        ResultView.printAskManualCount();
        try {
            Count manualCount = InputView.readCount();
            checkManualCountIsSmallerThanTotalCount(manualCount, totalCount);
            return manualCount;
        } catch (LottoException lottoException) {
            ResultView.printErrorMessage(lottoException);
            return getManualCount(totalCount);
        }
    }

    private void checkManualCountIsSmallerThanTotalCount(Count manualCount, Count totalCount) {
        if (manualCount.isBiggerThan(totalCount)) {
            throw new LottoException(LottoErrorCode.INVALID_MANUAL_COUNT);
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
