package lotto.domain;

import java.util.stream.IntStream;
import lotto.util.Constants;

public class Result {
    private static final String STR_RESULT_TITLE = "당첨 통계\n";
    private static final String STR_RESULT_SEPARATOR = "---------\n";
    private static final String STR_RESULT_PRIZES = "%s개 일치 (%s원) - %s개\n";
    private static final int[] INT_RESULT_PRIZES = {5000, 50000, 1500000, 2000000000};
    private static final String STR_RESULT_RETURN_RATE = "총 수익률은 %.2f입니다.";
    private static final String STR_RESULT_RETURN_RATE_UNDER_1 = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
    private static final int PRIZES_COUNT = 4;
    private static final int MIN_CORRECT_COUNT = 2;
    
    private int[] prizes;
    private int prizeMoney;

    public Result() {
        this.prizes = new int[PRIZES_COUNT];
        this.prizeMoney = 0;
    }

    public void setResult(int correctCount) {
        if (correctCount > MIN_CORRECT_COUNT) {
            int idx = correctCount - 3;
            this.prizes[idx]++;
            this.prizeMoney += INT_RESULT_PRIZES[idx];
        }
    }

    public String toString(int usedMoney) {
        StringBuilder sb = new StringBuilder();
        double returnRate = (double) this.prizeMoney / usedMoney;
        double returnRateStr = Math.floor(returnRate * 100) / 100;

        sb.append(STR_RESULT_TITLE);
        sb.append(STR_RESULT_SEPARATOR);

        IntStream.rangeClosed(1, PRIZES_COUNT).forEach(i -> {
            int correctCount = i + MIN_CORRECT_COUNT;
            String formattedString = String.format(STR_RESULT_PRIZES, correctCount, INT_RESULT_PRIZES[i], this.prizes[i]);
            sb.append(formattedString);
        });

        sb.append(String.format(STR_RESULT_RETURN_RATE, returnRateStr));
        if (returnRate < 1) {
            sb.append(STR_RESULT_RETURN_RATE_UNDER_1);
        }

        return sb.toString();
    }
}
