package lotto.view;

import lotto.model.Game;
import lotto.model.LottoNumber;
import lotto.model.Rank;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    private static final String PURCHASED_GAME_COUNT = "수동으로 %s장, 자동으로 %s개를 구매했습니다.\n";
    private static final String RESULT_TITLE_MESSAGE = "당첨 통계\n---------";
    private static final String MATCHED_RESULT_MESSAGE_PREFIX = "%s개 일치";
    private static final String MATCHED_RESULT_MESSAGE_SUFFIX = " (%s원) - %s개";
    private static final String MATCHED_RESULT_MESSAGE_FOR_SECOND_RANK = ", 보너스 볼 일치";
    private static final String EARNING_RATE_MESSAGE = "총 수익률은 %s입니다.";

    public ResultView() {
        throw new AssertionError();
    }

    /**
     * 구매금액 출력
     *
     * @param gameCount
     */
    public static void printPurchasedGameCount(int gameCount, int manualGameCount) {
        System.out.println(String.format(PURCHASED_GAME_COUNT, manualGameCount, gameCount));
    }

    /**
     * 구매한 게임목록 출력
     *
     * @param gameList
     */
    public static void printPurchaseGames(List<Game> gameList) {
        gameList.forEach(game -> {
            List<Integer> printNumbers = game.getNumbers()
                    .stream()
                    .map(LottoNumber::getValue)
                    .collect(Collectors.toList());
            System.out.println(printNumbers);
        });
    }

    /**
     * 결과 출력
     *
     * @param results
     */
    public static Integer printResult(LinkedHashMap<Rank, Integer> results) {
        System.out.println(RESULT_TITLE_MESSAGE);

        return results.entrySet()
                .stream()
                .filter(entry -> !entry.getKey().equals(Rank.MISS))
                .map(entry -> {
                    printMatchedCountByRank(entry.getKey(), entry.getValue());
                    return entry.getKey().getWinningMoney() * entry.getValue();
                })
                .collect(Collectors.summingInt(Integer::intValue));
    }

    /**
     * 랭킹 별 일치하는 번호 갯수를 출력
     *
     * @param rank
     * @param matchedCount
     */
    private static void printMatchedCountByRank(Rank rank, Integer matchedCount) {
        String appendSecondRankMessage = rank == Rank.SECOND ? MATCHED_RESULT_MESSAGE_FOR_SECOND_RANK : "";
        String messageFormat = MATCHED_RESULT_MESSAGE_PREFIX + appendSecondRankMessage + MATCHED_RESULT_MESSAGE_SUFFIX;
        System.out.println(String.format(messageFormat, rank.getCountOfMatch(), rank.getWinningMoney(), matchedCount));
    }

    /**
     * 수익률 출력
     *
     * @param purchaseAmount
     */
    public static void printEarningRate(int purchaseAmount, int totalPrizeMoney) {
        double earningRate = Math.round(totalPrizeMoney / purchaseAmount * 100) / 100.0;
        System.out.println(String.format(EARNING_RATE_MESSAGE, earningRate));
    }

}
