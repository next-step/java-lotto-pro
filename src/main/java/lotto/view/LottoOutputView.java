package lotto.view;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Map;
import lotto.model.Count;
import lotto.model.LottoNumber;
import lotto.model.LottoNumbers;
import lotto.model.LottoRank;
import lotto.model.LottoRanks;
import lotto.model.ProfitResult;

public final class LottoOutputView {
    private static final DecimalFormat formatter = new DecimalFormat("###,###");
    private static final Long RESULT_DEFAULT_VALUE = 0L;
    private static final String PURCHASE_QUANTITY_MESSAGE = "수동으로 %d장, 자동으로 %d장를 구매했습니다.\n";
    private static final String RESULT_START_MESSAGE = "당첨 통계\n---------\n";
    private static final String RANK_NORMAL_RESULT_MESSAGE = "%d개 일치 (%s)원 - %d개\n";
    private static final String RANK_BONUS_RESULT_MESSAGE = "%d개 일치, 보너스 볼 일치 (%s)원 - %d개\n";
    private static final String PROFIT_RATE_MESSAGE = "총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 %s라는 의미임)";

    private LottoOutputView() {
    }

    public static void printPurchaseResult(Count manualCount, LottoNumbers lottoNumbers) {
        printPurchaseQuantity(manualCount.getValue(), lottoNumbers.getQuantity() - manualCount.getValue());
        lottoNumbers.getLottoNumbers()
                .forEach(LottoOutputView::printLottoNumber);
    }

    private static void printPurchaseQuantity(int manualQuantity, int autoQuantity) {
        System.out.printf(PURCHASE_QUANTITY_MESSAGE, manualQuantity, autoQuantity);
    }

    private static void printLottoNumber(LottoNumber lottoNumber) {
        System.out.println(lottoNumber.getLottoNumber());
    }

    public static void printRankResult(LottoRanks lottoRanks) {
        Map<LottoRank, Long> result = lottoRanks.resultLottoRanks();
        System.out.printf(RESULT_START_MESSAGE);
        Arrays.asList(LottoRank.FIFTH, LottoRank.FOURTH, LottoRank.THIRD, LottoRank.SECOND, LottoRank.FIRST)
                .forEach(rank -> printEachRank(rank, result.getOrDefault(rank, RESULT_DEFAULT_VALUE)));
    }

    private static void printEachRank(LottoRank rank, Long count) {
        System.out.printf(choiceRankMessage(rank),
                rank.getHits(),
                convertDecimalFormat(rank.getCashPrize()),
                count
        );
    }

    private static String choiceRankMessage(LottoRank rank) {
        return rank == LottoRank.SECOND ? RANK_BONUS_RESULT_MESSAGE : RANK_NORMAL_RESULT_MESSAGE;
    }

    private static String convertDecimalFormat(int number) {
        return formatter.format(number);
    }

    public static void printProfitRate(LottoRanks lottoRanks) {
        double profitRate = lottoRanks.getProfitRate();
        System.out.printf(PROFIT_RATE_MESSAGE,
                profitRate,
                ProfitResult.of(profitRate).getTitle()
        );
    }

    public static void printErrorMessage(RuntimeException re) {
        System.out.println(re.getMessage());
    }
}
