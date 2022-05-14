package lotto.enums;

import calculator.utils.StringUtils;
import java.util.Arrays;
import java.util.List;
import lotto.constants.LottoGuideMessage;

public enum WinningRank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

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
            .orElse(MISS);
    }

    public static List<WinningRank> winningValues() {
        return Arrays.asList(FIFTH, FOURTH, THIRD, SECOND, FIRST);
    }

    public static boolean isWinningRank(WinningRank winningRank) {
        return winningValues().contains(winningRank);
    }

    public int getWinningCount() {
        return this.winningCount;
    }

    public int getPrizeMoney() {
        return this.prizeMoney;
    }

    public String additionalWinningRankDescription() {
        return this == SECOND ? LottoGuideMessage.WINNING_STATISTICS_BONUS_BALL : StringUtils.EMPTY;
    }
}
