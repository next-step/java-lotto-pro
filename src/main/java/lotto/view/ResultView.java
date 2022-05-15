package lotto.view;

import lotto.domain.LottoNumbers;
import lotto.domain.LottoRanks;
import lotto.enums.LottoRank;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Collections;

import static lotto.common.Messages.*;
import static lotto.domain.LottoResult.isCriterionRate;

public class ResultView {
    private static final DecimalFormat decimalFormat = new DecimalFormat("#.##");

    public static void purchasesCountMessage(int purchasesCount) {
        System.out.printf((PURCHASES_COUNT_MESSAGE) + "%n", purchasesCount);
    }

    public static void resultLottoNumbers(LottoNumbers lottoNumbers) {
        System.out.println(lottoNumbers);
    }

    public static void lottoGameResultMessage(LottoRanks lottoRanks) {
        System.out.println(WINNING_STATISTICS);
        System.out.println(SEPARATOR);

        Arrays.stream(LottoRank.values()).forEach(
                lottoRank -> System.out.printf(
                        (GAME_RESULT_MESSAGE) + "%n",
                        lottoRank.getMatchingCount(),
                        lottoRank.getPrizeMoney(),
                        Collections.frequency(lottoRanks.getLottoRanks(), lottoRank)
                )
        );
    }

    public static void lottoGameStatisticsMessage(double lottoGameEarningsRate) {
        String earningsRateFormat = decimalFormat.format(lottoGameEarningsRate);
        String criterionRateMessage = criterionRateMessage(isCriterionRate(lottoGameEarningsRate));

        System.out.printf((GAME_RESULT_EARNINGS_RATE) + "%n", earningsRateFormat);
        System.out.printf((GAME_RESULT_CRITERION_MESSAGE), criterionRateMessage);
    }

    private static String criterionRateMessage(boolean criterionRate) {
        return criterionRate ? PROFIT_TEXT : LOSS_TEXT;
    }
}
