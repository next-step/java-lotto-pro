package lotto.view;

import lotto.domain.*;

import static lotto.constants.LottoGameConstant.PROFIT_CRITERIA;
import static lotto.constants.LottoGameMessage.*;

public class ResultView {
    private ResultView() {}

    public static void printCount(LottoCount availableLottoCount, LottoCount manualPurchasedLottoCount) {
        int manualPurchasedLottoCountValue = manualPurchasedLottoCount.getCount();
        int autoPurchasedLottoCountValue = availableLottoCount.minus(manualPurchasedLottoCount).getCount();
        System.out.printf(PURCHASED_LOTTO_COUNT_INFORMATION, manualPurchasedLottoCountValue, autoPurchasedLottoCountValue);
        System.out.println();
    }

    public static void printLottoTickets(LottoTickets lottoTickets) {
        lottoTickets.getLottoTickets().forEach(ResultView::printLottoTicket);
        System.out.println();
    }

    private static void printLottoTicket(LottoTicket lottoTicket) {
        System.out.println(lottoTicket.toString());
    }

    public static void printStatistics(LottoPrizes lottoPrizes, Money money) {
        printStatisticsHeader();
        printMatchResult(lottoPrizes, LottoPrize.WIN_WITH_3_MATCHES);
        printMatchResult(lottoPrizes, LottoPrize.WIN_WITH_4_MATCHES);
        printMatchResult(lottoPrizes, LottoPrize.WIN_WITH_5_MATCHES);
        printMatchResult(lottoPrizes, LottoPrize.WIN_WITH_5_MATCHES_AND_BONUS);
        printMatchResult(lottoPrizes, LottoPrize.WIN_WITH_FULL_MATCHES);
        printProfitRate(lottoPrizes, money);
    }

    private static void printStatisticsHeader() {
        System.out.println();
        System.out.println(LOTTO_STATISTICS_INFORMATION_TITLE);
        System.out.println(DIVIDER);
    }

    private static void printMatchResult(LottoPrizes lottoPrizes, LottoPrize rank) {
        int count = calculateMatchCount(lottoPrizes, rank);
        String format = String.format(STATISTICS_PER_NUMBER_OF_MATCH, rank.getNumberOfMatch(), rank.additionalWinningStatistics(), rank.getPrize(), count);
        System.out.println(format);
    }

    private static int calculateMatchCount(LottoPrizes lottoPrizes, LottoPrize rank) {
        return (int) lottoPrizes.getLottoPrizes().stream()
                .filter(result -> result.equals(rank))
                .count();
    }

    private static void printProfitRate(LottoPrizes matchResults, Money money) {
        double profitRate = calculateProfitRate(matchResults, money);
        System.out.printf(TOTAL_PROFIT_RESULT, profitRate);
        if (profitRate < PROFIT_CRITERIA) {
            System.out.printf(TOTAL_PROFIT_DESCRIPTION, HAS_LOSS);
        }
        if (profitRate > PROFIT_CRITERIA) {
            System.out.printf(TOTAL_PROFIT_DESCRIPTION, HAS_PROFIT);
        }
        if (profitRate == PROFIT_CRITERIA) {
            System.out.printf(TOTAL_PROFIT_DESCRIPTION, HAS_NOTHING);
        }
    }

    private static double calculateProfitRate(LottoPrizes lottoPrizes, Money money) {
        int totalWinningPrize = lottoPrizes.getLottoPrizes().stream()
                .mapToInt(LottoPrize::getPrize).sum();

        return (totalWinningPrize * 1.0) / (money.getMoney() * 1.0);
    }
}
