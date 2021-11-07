package lotto.view;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class ResultView {

    private static final String PURCHASED_GAME_COUNT = "%s개를 구매했습니다.";
    private static final String RESULT_TITLE_MESSAGE = "당첨 통계\r\n---------";
    private static final Map<Integer, Integer> PRIZE_MONEY = new HashMap<Integer, Integer>(){{
        put(3, 5_000);
        put(4, 50_000);
        put(5, 1_500_000);
        put(6, 2_000_000_000);
    }};
    private static final String MATCHED_RESULT_MESSAGE = "%s개 일치 (%s원)- %s개";
    private static final String EARNING_RATE_MESSAGE = "총 수익률은 %s입니다.";
    private static double totalPrizeMoney = 0.0;

    public ResultView() {
        throw new AssertionError();
    }

    public static void printPurchasedGameCount(int gameCount) {
        System.out.println(String.format(PURCHASED_GAME_COUNT, gameCount));
    }

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
