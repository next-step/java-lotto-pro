package view;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import lotto.domain.LottoResult;
import lotto.domain.LottoStatistics;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;
import lotto.exception.LottoException;

public class ResultView {
    private static final String NEW_LINE = "\n";
    private static final String COMMA_SPACE = ", ";
    private static final long ZERO_COUNT = 0L;

    public static void printNumberOfPurchasedLotto(long number) {
        System.out.println(String.format(OutputMessage.NUMBER_OF_PURCHASED_LOTTO_FORMAT.getMessage(), number));
    }

    public static void printLottoTickets(LottoTickets lottoTickets) {
        System.out.println(lottoTickets.getLottoTicketList()
            .stream()
            .map(ResultView::makeLottoTicketMessage)
            .collect(Collectors.joining(NEW_LINE)));
    }

    private static String makeLottoTicketMessage(LottoTicket lottoTicket) {
        return String.format(OutputMessage.LOTTO_TICKET_FORMAT.getMessage(),
            lottoTicket.getLottoNumbers().stream()
                .map(lottoNumber -> String.valueOf(lottoNumber.getNumber()))
                .collect(Collectors.joining(COMMA_SPACE)));
    }

    public static void printAskPurchaseAmount() {
        System.out.println(OutputMessage.ASK_PURCHASE_AMOUNT.getMessage());
    }

    public static void printErrorMessage(LottoException lottoException) {
        System.out.println(lottoException.getMessage());
    }

    public static void printAskWinnerTicket() {
        System.out.println();
        System.out.println(OutputMessage.ASK_WINNER_TICKET.getMessage());
    }

    public static void printAskBonusNumber() {
        System.out.println(OutputMessage.ASK_BONUS_NUMBER.getMessage());
    }

    public static void printWinningStatistics(LottoStatistics lottoStatistics) {
        System.out.println();
        System.out.println(OutputMessage.STATISTICS_INTRO.getMessage());
        System.out.println(makeLottoResultsMessage(lottoStatistics.getResultCounts()));
        System.out.println(String.format(OutputMessage.TOTAL_EARNING_RATE_FORMAT.getMessage(),
            lottoStatistics.getEarningRate().getRate()));
    }

    private static String makeLottoResultsMessage(Map<LottoResult, Long> resultCounts) {
        return Arrays.stream(LottoResult.values())
            .filter(lottoResult -> lottoResult != LottoResult.MISS)
            .map(lottoResult -> String.format(OutputMessage.LOTTO_RESULTS_FORMAT.getMessage(),
                makeLottoResultMessage(lottoResult), resultCounts.getOrDefault(lottoResult, ZERO_COUNT)))
            .collect(Collectors.joining(NEW_LINE));
    }

    private static String makeLottoResultMessage(LottoResult lottoResult) {
        if (LottoResult.SECOND == lottoResult) {
            return String.format(OutputMessage.LOTTO_BONUS_RESULT_FORMAT.getMessage(),
                lottoResult.getCorrectCount(), lottoResult.getLottoMoney().getMoney());
        }

        return String.format(OutputMessage.LOTTO_RESULT_FORMAT.getMessage(),
            lottoResult.getCorrectCount(), lottoResult.getLottoMoney().getMoney());
    }
}
