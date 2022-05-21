package lotto.domain;

public enum LottoRank {
    FIRST(6, 2000000000, false),
    SECOND(5, 30000000, true),
    THIRD(5, 1500000, false),
    FOURTH(4, 50000, false),
    FIFTH(3, 5000, false),
    NONE(0, 0, false);

    private final int match;
    private final long prize;
    private final boolean hasBonus;

    LottoRank(int match, long prize, boolean hasBonus) {
        this.match = match;
        this.prize = prize;
        this.hasBonus = hasBonus;
    }

    private boolean matchBonus(boolean hasBonus) {
        return this.hasBonus == hasBonus;
    }

    public int getMatch() {
        return match;
    }

    public boolean isMatch(int match) {
        return this.match == match;
    }

    public long getPrize() {
        return prize;
    }
}