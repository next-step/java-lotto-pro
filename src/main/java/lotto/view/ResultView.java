package lotto.view;

import java.util.LinkedHashMap;

import static lotto.common.Constants.PRIZE_MONEY;

public class ResultView {

    private static final String RESULT_TITLE_MESSAGE = "당첨 통계\r\n---------";
    private static final String MATCHED_RESULT_MESSAGE = "%s개 일치 (%s원)- %s개";
    private static final String EARNING_RATE_MESSAGE = "총 수익률은 %s입니다.";
    private static double totalPrizeMoney = 0.0;

    public static void printResult(LinkedHashMap<Integer, Integer> results) {
        System.out.println(RESULT_TITLE_MESSAGE);

        PRIZE_MONEY.forEach((matchCount, prizeMoney) -> {
            System.out.println(String.format(MATCHED_RESULT_MESSAGE, matchCount, prizeMoney, results.get(matchCount)));
            totalPrizeMoney += prizeMoney * results.get(matchCount);
        });
    }

    public static void printEarningRate(int purchaseAmount) {
        double earningRate = Math.round(totalPrizeMoney / purchaseAmount * 100) / 100.0;
        System.out.println(String.format(EARNING_RATE_MESSAGE, earningRate));
    }

}
