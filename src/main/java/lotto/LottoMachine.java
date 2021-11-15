package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import lotto.domain.Count;
import lotto.domain.Money;
import lotto.domain.Ball;
import lotto.domain.Ticket;
import lotto.domain.Tickets;
import lotto.domain.WinnerBall;
import lotto.exception.LottoErrorCode;
import lotto.exception.LottoException;
import lotto.factory.TicketFactory;
import view.InputView;
import view.ResultView;

public class LottoMachine {
    private static final String COMMA = ",";
    private static final String ALL_SPACES_PATTERN = "\\s";
    private static final String EMPTY = "";

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
            return new Money(InputView.readLine());
        } catch (LottoException lottoException) {
            ResultView.printErrorMessage(lottoException);
            return getMoney();
        }
    }

    private Ticket getTicket() {
        ResultView.printAskWinnerTicket();
        try {
            List<Integer> numbers = Arrays.stream(removeAllSpaces(InputView.readLine()).split(COMMA))
                .map(this::parseInt)
                .collect(Collectors.toList());

            return new Ticket(numbers);
        } catch (LottoException lottoException) {
            ResultView.printErrorMessage(lottoException);
            return getTicket();
        }
    }

    private WinnerBall getWinnerTicket(Ticket ticket) {
        ResultView.printAskBonusNumber();

        try {
            Ball ball = new Ball(parseInt(removeAllSpaces(InputView.readLine())));
            return new WinnerBall(ticket, ball);
        } catch (LottoException lottoException) {
            ResultView.printErrorMessage(lottoException);
            return getWinnerTicket(ticket);
        }

    }

    private String removeAllSpaces(String numbers) {
        return numbers.replaceAll(ALL_SPACES_PATTERN, EMPTY);
    }

    private int parseInt(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new LottoException(LottoErrorCode.INVALID_NUMBER);
        }
    }
}
