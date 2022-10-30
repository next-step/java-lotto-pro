package lotto.domain;

import java.util.Arrays;

public enum WinningRank {
    MISS_MATCH(0, 0, false),
    FIFTH(3, 5_000, true),
    FOURTH(4, 50_000, true),
    THIRD(5, 1_500_000, true),
    SECOND(5, 30_000_000, true),
    FIRST(6, 2_000_000_000, true);

    private static final String PRINT_STATISTICS_FORMAT = "%d개 일치 (%d원)- %d개\n";
    private static final String PRINT_SECOND_STATISTICS_FORMAT = "%d개 일치, 보너스 볼 일치(%d원)- %d개\n";
    private static final String BLANK_STRING = "";

    private final int matchCount;
    private final int winningMoney;
    private final boolean isDisplay;

    WinningRank(int matchCount, int winningMoney, boolean isDisplay) {
        this.matchCount = matchCount;
        this.winningMoney = winningMoney;
        this.isDisplay = isDisplay;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public boolean isDisplay() {
        return isDisplay;
    }

    public static WinningRank match(int matchCount, boolean matchBonus) {
        if (isSecondMatchCondition(matchCount, matchBonus)) {
            return SECOND;
        }

        return Arrays.stream(WinningRank.values())
                .filter(rank -> rank.matchCount == matchCount)
                .findFirst()
                .orElse(MISS_MATCH);
    }

    private static boolean isSecondMatchCondition(int matchCount, boolean matchBonus) {
        return matchBonus && SECOND.matchCount == matchCount;
    }

    public String getStatisticsMessage(Long winningCount) {
        if (this.isDisplay()) {
            return String.format(this == SECOND ? PRINT_SECOND_STATISTICS_FORMAT : PRINT_STATISTICS_FORMAT,
                    this.getMatchCount(),
                    this.getWinningMoney(),
                    winningCount);
        }
        return BLANK_STRING;
    }
}
