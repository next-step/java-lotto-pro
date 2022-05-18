package lotto.domain;

public enum Prize {
    NO_MATCHES(0, 0),
    THREE_MATCHES(3, 5_000),
    FOUR_MATCHES(4, 50_000),
    FIVE_MATCHES(5, 1_500_000),
    FIVE_MATCHES_WITH_BONUS_BALL(5, 30_000_000),
    SIX_MATCHES(6, 2_000_000_000),
    ;

    private final int matchCount;
    private final int prize;

    Prize(final int matchCount, final int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
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

    public int getPrize() {
        return prize;
    }

    public String resultMessage(final int matches) {
        return String.format("%d개 일치 (%d원)- %d", matchCount, prize, matches);
    }
}
