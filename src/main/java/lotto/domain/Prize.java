package lotto.domain;

import java.util.Arrays;
import java.util.List;

public enum Prize {
    NO_MATCHES(0, 0L, ""),
    THREE_MATCHES(3, 5_000L, "3개 일치"),
    FOUR_MATCHES(4, 50_000L, "4개 일치"),
    FIVE_MATCHES(5, 1_500_000L, "5개 일치"),
    FIVE_MATCHES_WITH_BONUS_BALL(5, 30_000_000L, "5개 일치, 보너스 볼 일치"),
    SIX_MATCHES(6, 2_000_000_000L, "6개 일치"),
    ;

    private final int matchCount;
    private final long prize;
    private final String resultPrefix;

    Prize(final int matchCount, final long prize, final String resultPrefix) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.resultPrefix = resultPrefix;
    }

    public static List<Prize> printablePrizes() {
        return Arrays.asList(THREE_MATCHES, FOUR_MATCHES, FIVE_MATCHES, FIVE_MATCHES_WITH_BONUS_BALL, SIX_MATCHES);
    }

    public static Prize checkPrize(final int matchCount, final boolean bonusBallMatches) {
        if (matchCount == 5 && bonusBallMatches) {
            return FIVE_MATCHES_WITH_BONUS_BALL;
        }
        return findByMatchCount(0, matchCount);
    }

    private static Prize findByMatchCount(final int index, final int matchCount) {
        final Prize current = values()[index];
        if (!FIVE_MATCHES_WITH_BONUS_BALL.equals(current) && matchCount == current.matchCount) {
            return current;
        }
        return findByMatchCount(index + 1, matchCount);
    }

    public long getPrize() {
        return prize;
    }

    public String resultMessage(final int matches) {
        return String.format("%s (%d원)- %d", resultPrefix, prize, matches);
    }
}
