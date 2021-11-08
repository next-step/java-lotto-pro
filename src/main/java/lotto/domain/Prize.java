package lotto.domain;

public enum Prize {
    THREE_MATCH_PRIZE(3, 5_000),
    FOUR_MATCH_PRIZE(4, 50_000),
    FIVE_MATCH_PRIZE(5, 1_500_000),
    SIX_MATCH_PRIZE(6, 2_000_000_000);

    private final int matchCount;
    private final int prizeMoney;

    Prize(int matchCount, int prizeMoney) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public int getMatchCount() {
        return matchCount;
    }
}