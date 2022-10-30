package lotto.domain;

import java.util.stream.IntStream;
import lotto.util.Constants;

public class Result {
    private int[] prizes;
    private int prizeMoney;

    public Result() {
        this.prizes = new int[Constants.FOUR];
        this.prizeMoney = 0;
    }

    public void setResult(int correctCount) {
        if (correctCount > 2) {
            int idx = Math.abs(correctCount - Constants.THREE);
            this.prizes[idx]++;
            this.prizeMoney += Constants.INT_RESULT_PRIZES[idx];
        }
    }

    public String toString(int usedMoney) {
        StringBuilder sb = new StringBuilder();
        double returnRate = (double) this.prizeMoney / usedMoney;
        double returnRateStr = Math.floor(returnRate * Constants.HUNDRED) / Constants.HUNDRED;

        sb.append(Constants.STR_RESULT_TITLE);
        sb.append(Constants.STR_RESULT_SEPARATOR);

        IntStream.rangeClosed(Constants.ZERO, Constants.THREE).forEach(i -> {
            int correctCount = i + Constants.THREE;
            String formattedString = String.format(Constants.STR_RESULT_PRIZES, correctCount, Constants.INT_RESULT_PRIZES[i], this.prizes[i]);
            sb.append(formattedString);
        });

        sb.append(String.format(Constants.STR_RESULT_RETURN_RATE, returnRateStr));
        if (returnRate < 1) {
            sb.append(Constants.STR_RESULT_RETURN_RATE_UNDER_1);
        }

        return sb.toString();
    }
}
