package lotto.view;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import lotto.model.LottoNumber;
import lotto.model.LottoNumbers;
import lotto.model.LottoPurchaseQuantity;
import lotto.model.LottoRank;
import lotto.model.LottoRanks;

public final class LottoOutputView {
    private static final DecimalFormat formatter = new DecimalFormat("###,###");
    private static final Long RESULT_DEFAULT_VALUE = 0L;
    private static final int PROFIT_RATE_STANDARD = 1;
    private static final String PURCHASE_QUANTITY_MESSAGE = "%s개를 구매했습니다.\n";
    private static final String RESULT_START_MESSAGE = "당첨 통계\n---------\n";
    private static final String RANK_RESULT_MESSAGE = "%d개 일치 (%s)원 - %d개\n";
    private static final String PROFIT_RATE_MESSAGE = "총 수익률은 %.2f입니다.(기준이 %d이기 때문에 결과적으로 %s라는 의미임)";


    public static void printPurchaseQuantity(LottoPurchaseQuantity lottoPurchaseQuantity) {
        System.out.printf(PURCHASE_QUANTITY_MESSAGE, lottoPurchaseQuantity.getQuantity());
    }

    public static void printPurchaseLottoNumbers(LottoNumbers lottoNumbers) {
        List<LottoNumber> lottoNumberList = lottoNumbers.getLottoNumbers();
        lottoNumberList.forEach(LottoOutputView::printLottoNumber);
    }

    private static void printLottoNumber(LottoNumber lottoNumber) {
        System.out.println(lottoNumber.getLottoNumber());
    }

    public static void printRankResult(LottoRanks lottoRanks) {
        Map<LottoRank, Long> result = lottoRanks.resultLottoRanks();
        System.out.printf(RESULT_START_MESSAGE);
        Arrays.asList(LottoRank.FOURTH, LottoRank.THIRD, LottoRank.SECOND, LottoRank.FIRST)
                .forEach(rank -> printEachRank(rank, result.getOrDefault(rank, RESULT_DEFAULT_VALUE)));
    }

    private static void printEachRank(LottoRank rank, Long count) {
        System.out.printf(RANK_RESULT_MESSAGE,
                rank.getHits(),
                convertDecimalFormat(rank.getCashPrize()),
                count
        );
    }

    public static void printProfitRate(LottoPurchaseQuantity lottoPurchaseQuantity, LottoRanks lottoRanks) {
        double profitRate = lottoRanks.totalCashPrize() / (double) lottoPurchaseQuantity.getPurchasePrice();
        String result = profitRate > PROFIT_RATE_STANDARD ? "이득" : "손해";
        System.out.printf(PROFIT_RATE_MESSAGE, profitRate, PROFIT_RATE_STANDARD, result);
    }

    private static String convertDecimalFormat(int number) {
        return formatter.format(number);
    }

    public static void printErrorMessage(RuntimeException re) {
        System.out.println(re.getMessage());
    }
}
