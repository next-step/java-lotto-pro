package lotto.domain;

public enum Prize {
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    FIRST(6, 2_000_000_000);

    private final int countOfMatch;
    private final int prizeMoney;

    Prize(int matchCount, int prizeMoney) {
        this.countOfMatch = matchCount;
        this.prizeMoney = prizeMoney;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }
}