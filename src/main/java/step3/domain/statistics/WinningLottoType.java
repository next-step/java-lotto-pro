package step3.domain.statistics;

import java.util.Arrays;

public enum WinningLottoType {

    NOTHING(0, 0),
    FOURTH(3, 5000),
    THIRD(4, 50000),
    SECOND(5, 1500000),
    FIRST(6, 2000000000);

    private final int matchCount;
    private final int winningAmount;

    WinningLottoType(int matchCount, int winningAmount) {
        this.matchCount = matchCount;
        this.winningAmount = winningAmount;
    }

    public static WinningLottoType findByMatchCount(int matchCount) {
        return Arrays.stream(values())
                .filter(winningLottoType -> winningLottoType.getMatchCount() == matchCount)
                .findFirst()
                .orElse(NOTHING);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getWinningAmount() {
        return winningAmount;
    }
}
