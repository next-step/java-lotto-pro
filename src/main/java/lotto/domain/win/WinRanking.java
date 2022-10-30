package lotto.domain.win;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.message.ErrorMessages;

public enum WinRanking {
    MISS(0, 0),
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000),
    ;

    private final int matchCount;
    private final int winningMoney;

    WinRanking(int matchCount, int winningMoney) {
        this.matchCount = matchCount;
        this.winningMoney = winningMoney;
    }

    public static WinRanking of(int matchCount, boolean hasBonusNumber) {
        if (isMissRanking(matchCount)) {
            return MISS;
        }

        if (isSecondRanking(matchCount, hasBonusNumber)) {
            return SECOND;
        }

        return Arrays.stream(WinRanking.values())
                .filter(winRanking -> winRanking != SECOND)
                .filter(winRanking -> winRanking.getMatchCount() == matchCount)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(
                        String.format(ErrorMessages.INVALID_MATCH_COUNT, matchCount))
                );
    }

    private static boolean isMissRanking(int matchCount) {
        return MISS.getMatchCount() <= matchCount && matchCount < FIFTH.getMatchCount();
    }

    private static boolean isSecondRanking(int matchCount, boolean bonusNumber) {
        return matchCount == SECOND.getMatchCount() && bonusNumber;
    }

    public static List<WinRanking> winnableRankings() {
        return Arrays.stream(WinRanking.values())
                .filter(winRanking -> winRanking != MISS)
                .collect(Collectors.toList());
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public boolean isSecond() {
        return this == SECOND;
    }
}
