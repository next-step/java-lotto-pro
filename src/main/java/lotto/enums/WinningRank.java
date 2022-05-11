package lotto.enums;

import java.util.Arrays;

public enum WinningRank {
    WIN_1(6, 2_000_000_000),
    WIN_2(5, 1_500_000),
    WIN_3(4, 50_000),
    WIN_4(3, 5_000),
    NO_WIN(0, 0);

    private final int winningCount;
    private final int prizeMoney;

    WinningRank(int winningCount, int prizeMoney) {
        this.winningCount = winningCount;
        this.prizeMoney = prizeMoney;
    }

    public static WinningRank valueOf(int winningCount) {
        return Arrays.stream(WinningRank.values())
            .filter(wr -> wr.getWinningCount() == winningCount)
            .findAny()
            .orElse(NO_WIN);
    }

    private int getWinningCount() {
        return this.winningCount;
    }
}
