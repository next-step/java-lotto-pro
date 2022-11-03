package lotto.view;

import lotto.WinningResult;

import java.util.Map;
import java.util.Optional;

import static lotto.WinningResult.WIN_FIRST;
import static lotto.WinningResult.WIN_FOURTH;
import static lotto.WinningResult.WIN_SECOND;
import static lotto.WinningResult.WIN_SECOND_BONUS;
import static lotto.WinningResult.WIN_THIRD;

public class ResultView {
    private static final String NEW_LINE = System.getProperty("line.separator");

    private ResultView() {
        throw new IllegalStateException("유틸 클래스 입니다");
    }

    public static void printResult(Map<WinningResult, Long> winningResultMap) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("당첨 통계").append(NEW_LINE)
                .append("---------").append(NEW_LINE)
                .append("3개 일치 (").append(WIN_FOURTH.getWinningPrice()).append("원)- ")
                .append(Optional.ofNullable(winningResultMap.get(WIN_FOURTH)).orElse(0L)).append("개").append(NEW_LINE)
                .append("4개 일치 (").append(WIN_THIRD.getWinningPrice()).append("원)- ")
                .append(Optional.ofNullable(winningResultMap.get(WIN_THIRD)).orElse(0L)).append("개").append(NEW_LINE)
                .append("5개 일치 (").append(WIN_SECOND.getWinningPrice()).append("원)- ")
                .append(Optional.ofNullable(winningResultMap.get(WinningResult.WIN_SECOND)).orElse(0L)).append("개").append(NEW_LINE)
                .append("5개 일치, 보너스 볼 일치(").append(WIN_SECOND_BONUS.getWinningPrice()).append("원)- ")
                .append(Optional.ofNullable(winningResultMap.get(WinningResult.WIN_SECOND_BONUS)).orElse(0L)).append("개").append(NEW_LINE)
                .append("6개 일치 (").append(WIN_FIRST.getWinningPrice()).append("원)- ")
                .append(Optional.ofNullable(winningResultMap.get(WinningResult.WIN_FIRST)).orElse(0L)).append("개").append(NEW_LINE);
        System.out.println(stringBuilder);
    }

    public static void printProfitRate(double profitRate) {
        System.out.println("총 수익률은 " + String.format("%.2f", profitRate) + "입니다.");
    }
}
