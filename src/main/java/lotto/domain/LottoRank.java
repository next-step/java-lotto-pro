package lotto.domain;

public enum LottoRank {
    FIRST(6, 2000000000),
    SECOND(5, 1500000),
    THIRD(4, 50000),
    FOURTH(3, 5000);

    private final int match;
    private final long prize;

    LottoRank(int match, long prize) {
        this.match = match;
        this.prize = prize;
    }

    public static LottoRank findByMatch(int match) {
        for (LottoRank value : LottoRank.values()) {
            if (value.match == match) {
                return value;
            }
        }
        return null;
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