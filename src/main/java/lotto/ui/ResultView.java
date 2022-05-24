package lotto.ui;

import lotto.domain.Lotto;
import lotto.domain.LottoGame;
import lotto.domain.LottoRank;
import lotto.domain.LottoResult;

import java.util.Arrays;
import java.util.List;

public class ResultView {
    private static final String BUY_COUNT_MESSAGE = "수동으로 %d장, 자동으로 %d장을 구매했습니다.%n";
    private static final String DASH = "----------";
    private static final String RESULT_TITLE = "당첨 통계";
    private static final String RESULT = "%d개 일치%s (%s) - %d개%n";
    private static final String BONUS_MATCH_MESSAGE = ", 보너스 볼 일치";
    private static final String FLOOR = "%.2f";
    private static final String EMPTY_STRING = "";
    private static final String SAME = "본전";
    private static final String PROFIT = "이익";
    private static final String LOSS = "손해";
    private static final String RETURN_RATE = "총 수익률은 %s입니다.";
    private static final String RETURN_RATE_RESULT = "(기준이 1이기 때문에 결과적으로 %s(이)라는 의미임)";
    private static final int BASE_RETURN_RATE = 1;

    public static void printBuyLottos(LottoGame lottoGame) {
        System.out.printf(BUY_COUNT_MESSAGE, lottoGame.manualQuantity(), lottoGame.autoQuantity());
        printLottoNumbers(lottoGame.getLottos());
    }

    private static void printLottoNumbers(List<Lotto> lottoNumbers) {
        for (Lotto lotto : lottoNumbers) {
            System.out.println(lotto.toString());
        }
    }

    public static void printWinningResult(LottoResult lottoResult) {
        printResultTitle();
        printResult(lottoResult);
    }

    private static void printResultTitle() {
        System.out.println(RESULT_TITLE);
        System.out.println(DASH);
    }

    private static void printResult(LottoResult lottoResult) {
        Arrays.stream(LottoRank.values()).forEach(rank ->
            System.out.printf(RESULT,
                    rank.getMatchCount(), secondMessage(rank),
                    rank.getWinningMoney().krw(), lottoResult.winningCount(rank)));
    }

    private static String secondMessage(LottoRank rank) {
        if (isSecond(rank)) {
            return BONUS_MATCH_MESSAGE;
        }
        return EMPTY_STRING;
    }

    private static boolean isSecond(LottoRank rank) {
        return rank == LottoRank.SECOND;
    }

    public static void printReturnRate(double rateOfReturn) {
        System.out.printf(RETURN_RATE, getFloorValue(rateOfReturn));
        System.out.printf(RETURN_RATE_RESULT, incomeMessage(rateOfReturn));
    }


    private static String getFloorValue(double returnRate) {
        return String.format(FLOOR, Math.floor(returnRate * 100.0) / 100.0);
    }

    private static String incomeMessage(double returnRate) {
        if (returnRate == BASE_RETURN_RATE) {
            return SAME;
        }
        if (returnRate > BASE_RETURN_RATE) {
            return PROFIT;
        }
        return LOSS;
    }
}
