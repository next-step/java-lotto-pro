package study.lotto.dto;

import java.math.BigDecimal;

public class DivisionResult {
    private final int matchCount;
    private final BigDecimal prize;
    private final int winningCount;

    public DivisionResult(int matchCount, BigDecimal prize, int winningCount) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.winningCount = winningCount;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public BigDecimal getPrize() {
        return prize;
    }

    public int getWinningCount() {
        return winningCount;
    }
}
