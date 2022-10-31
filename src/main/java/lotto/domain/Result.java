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
    private static final int FOUR = 4;
    private static final int THREE = 3;
    private static final int HUNDRED = 100;
    
    private int[] prizes;
    private int prizeMoney;

    public Result() {
        this.prizes = new int[FOUR];
        this.prizeMoney = 0;
    }

    public void setResult(int correctCount) {
        if (correctCount > 2) {
            int idx = Math.abs(correctCount - THREE);
            this.prizes[idx]++;
            this.prizeMoney += INT_RESULT_PRIZES[idx];
        }
    }

    public String toString(int usedMoney) {
        StringBuilder sb = new StringBuilder();
        double returnRate = (double) this.prizeMoney / usedMoney;
        double returnRateStr = Math.floor(returnRate * HUNDRED) / HUNDRED;

        sb.append(STR_RESULT_TITLE);
        sb.append(STR_RESULT_SEPARATOR);

        IntStream.rangeClosed(Constants.ZERO, THREE).forEach(i -> {
            int correctCount = i + THREE;
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
