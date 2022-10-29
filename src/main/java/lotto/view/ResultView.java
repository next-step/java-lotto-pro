package lotto.view;

import lotto.WinningResult;
import lotto.WinningResultBag;

import static lotto.WinningResultBag.MATCH_FIVE_REWARD;
import static lotto.WinningResultBag.MATCH_FOUR_REWARD;
import static lotto.WinningResultBag.MATCH_SIX_REWARD;
import static lotto.WinningResultBag.MATCH_THREE_REWARD;

public class ResultView {
    private static final String NEW_LINE = System.getProperty("line.separator");

    public static void printResult(WinningResultBag results) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("당첨 통계").append(NEW_LINE)
                .append("---------").append(NEW_LINE)
                .append("3개 일치 (").append(MATCH_THREE_REWARD).append("원)- ")
                .append(results.countByWinningResult(WinningResult.MATCH_THREE)).append("개").append(NEW_LINE)
                .append("4개 일치 (").append(MATCH_FOUR_REWARD).append("원)- ")
                .append(results.countByWinningResult(WinningResult.MATCH_FOUR)).append("개").append(NEW_LINE)
                .append("5개 일치 (").append(MATCH_FIVE_REWARD).append("원)- ")
                .append(results.countByWinningResult(WinningResult.MATCH_FIVE)).append("개").append(NEW_LINE)
                .append("6개 일치 (").append(MATCH_SIX_REWARD).append("원)- ")
                .append(results.countByWinningResult(WinningResult.MATCH_SIX)).append("개").append(NEW_LINE)
                .append("총 수익률은 ").append(String.format("%.2f", results.calculateProfitRate())).append("입니다.");
        System.out.println(stringBuilder);
    }
}
