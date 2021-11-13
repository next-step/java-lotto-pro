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
    private static final String WON = "원";

    public static void printNumberOfPurchasedLotto(long number) {
        System.out.println(number + "개를 구매했습니다.");
    }

    public static void printLottoTickets(LottoTickets lottoTickets) {
        System.out.println(lottoTickets.getLottoTicketList()
            .stream()
            .map(ResultView::makeLottoTicketMessage)
            .collect(Collectors.joining(NEW_LINE)));
    }

    private static String makeLottoTicketMessage(LottoTicket lottoTicket) {
        return "[" +
            lottoTicket.getLottoNumbers()
                .stream()
                .map(lottoNumber -> String.valueOf(lottoNumber.getNumber()))
                .collect(Collectors.joining(COMMA_SPACE))
            + "]";
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

    public static void printWinningStatistics(LottoStatistics lottoStatistics) {
        System.out.println();
        System.out.println(OutputMessage.PRINT_STATISTICS_INTRO.getMessage());
        System.out.println(makeLottoResultsMessage(lottoStatistics.getResultCounts()));
        System.out.println("총 수익률은 " + lottoStatistics.getEarningRate().getRate() + " 입니다.");
    }

    private static String makeLottoResultsMessage(Map<LottoResult, Long> resultCounts) {
        return Arrays.stream(LottoResult.values())
            .filter(lottoResult -> lottoResult != LottoResult.NONE)
            .map(lottoResult -> makeLottoResultMessage(lottoResult) + "- " + resultCounts.getOrDefault(lottoResult,
                ZERO_COUNT) + "개")
            .collect(Collectors.joining(NEW_LINE));
    }

    private static String makeLottoResultMessage(LottoResult lottoResult) {
        return lottoResult.getCorrectCount() + "개 일치 (" + lottoResult.getLottoMoney().getMoney() + WON + ")";
    }
}
