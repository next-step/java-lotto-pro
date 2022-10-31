package lotto.view;

import lotto.WinningResult;

import java.util.Map;

import static lotto.WinningResultBag.MATCH_FIVE_REWARD;
import static lotto.WinningResultBag.MATCH_FOUR_REWARD;
import static lotto.WinningResultBag.MATCH_SIX_REWARD;
import static lotto.WinningResultBag.MATCH_THREE_REWARD;

public class ResultView {
    private static final String NEW_LINE = System.getProperty("line.separator");

    private ResultView() {
        throw new IllegalStateException("유틸 클래스 입니다");
    }

    public static void printResult(Map<WinningResult, Long> winningResultMap) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("당첨 통계").append(NEW_LINE)
                .append("---------").append(NEW_LINE)
                .append("3개 일치 (").append(MATCH_THREE_REWARD).append("원)- ")
                .append(winningResultMap.get(WinningResult.MATCH_THREE)).append("개").append(NEW_LINE)
                .append("4개 일치 (").append(MATCH_FOUR_REWARD).append("원)- ")
                .append(winningResultMap.get(WinningResult.MATCH_FOUR)).append("개").append(NEW_LINE)
                .append("5개 일치 (").append(MATCH_FIVE_REWARD).append("원)- ")
                .append(winningResultMap.get(WinningResult.MATCH_FIVE)).append("개").append(NEW_LINE)
                .append("6개 일치 (").append(MATCH_SIX_REWARD).append("원)- ")
                .append(winningResultMap.get(WinningResult.MATCH_SIX)).append("개").append(NEW_LINE);
        System.out.println(stringBuilder);
    }

    public static void printProfitRate(double profitRate) {
        System.out.println("총 수익률은 " + String.format("%.2f", profitRate) + "입니다.");
    }
}
