package view;

import java.util.Map;
import java.util.stream.Collectors;

import lotto.domain.Rank;
import lotto.domain.Statistics;
import lotto.domain.Ticket;
import lotto.domain.TicketCounts;
import lotto.domain.Tickets;
import lotto.exception.LottoException;

public class OutputView {
    private static final String NEW_LINE = "\n";
    private static final String COMMA_SPACE = ", ";
    private static final long ZERO_COUNT = 0L;

    private OutputView() {
    }

    public static void printNumberOfPurchasedLotto(TicketCounts ticketCounts) {
        System.out.println();
        System.out.println(String.format(OutputMessage.NUMBER_OF_PURCHASED_LOTTO_FORMAT.getMessage(),
            ticketCounts.getManualCount().getCount(), ticketCounts.getAutoCount().getCount()));
    }

    public static void printTickets(Tickets tickets) {
        System.out.println(tickets.getTickets()
            .stream()
            .map(OutputView::makeTicketMessage)
            .collect(Collectors.joining(NEW_LINE)));
    }

    private static String makeTicketMessage(Ticket ticket) {
        return String.format(OutputMessage.TICKET_FORMAT.getMessage(),
            ticket.getBalls().stream()
                .sorted()
                .map(ball -> String.valueOf(ball.getNumber()))
                .collect(Collectors.joining(COMMA_SPACE)));
    }

    public static void printAskPurchaseAmount() {
        System.out.println(OutputMessage.ASK_PURCHASE_AMOUNT.getMessage());
    }

    public static void printAskManualCount() {
        System.out.println();
        System.out.println(OutputMessage.ASK_MANUAL_COUNT.getMessage());
    }

    public static void printAskManualTicket() {
        System.out.println();
        System.out.println(OutputMessage.ASK_MANUAL_TICKET.getMessage());
    }

    public static void printErrorMessage(LottoException lottoException) {
        System.out.println(lottoException.getMessage());
    }

    public static void printAskWinnerTicket() {
        System.out.println();
        System.out.println(OutputMessage.ASK_WINNER_TICKET.getMessage());
    }

    public static void printAskBonusNumber() {
        System.out.println(OutputMessage.ASK_BONUS_BALL.getMessage());
    }

    public static void printWinningStatistics(Statistics statistics) {
        System.out.println();
        System.out.println(OutputMessage.STATISTICS_INTRO.getMessage());
        System.out.println(makeRanksMessage(statistics.getRankCounts()));
        System.out.println(String.format(OutputMessage.TOTAL_EARNING_RATE_FORMAT.getMessage(),
            statistics.getEarningRate().getRate()));
    }

    private static String makeRanksMessage(Map<Rank, Long> rankCounts) {
        return Rank.winningValues().stream()
            .map(rank -> makeRankCountMessage(rank, rankCounts.getOrDefault(rank, ZERO_COUNT)))
            .collect(Collectors.joining(NEW_LINE));
    }

    private static String makeRankCountMessage(Rank rank, long count) {
        return String.format(OutputMessage.RANKS_FORMAT.getMessage(), makeRankMessage(rank), count);
    }

    private static String makeRankMessage(Rank rank) {
        if (rank.isSecond()) {
            return String.format(OutputMessage.BONUS_RANK_FORMAT.getMessage(),
                rank.getCorrectCount(), rank.getMoney().getMoney());
        }

        return String.format(OutputMessage.RANK_FORMAT.getMessage(),
            rank.getCorrectCount(), rank.getMoney().getMoney());
    }
}
