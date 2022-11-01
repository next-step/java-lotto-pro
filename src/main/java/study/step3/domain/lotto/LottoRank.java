package study.step3.domain.lotto;

public enum LottoRank {
    FIRST_PLACE(6L, 2_000_000_000L),
    SECOND_PLACE(5L, 1_500_000L),
    THIRD_PLACE(4L, 50_000L),
    FOURTH_PLACE(3L, 5_000L),
    NONE(0L, 0L);

    private final long matchCount;
    private final long winningMoney;

    LottoRank(long matchCount, long winningMoney) {
        this.matchCount = matchCount;
        this.winningMoney = winningMoney;
    }

    public static LottoRank ofMatchCount(Long matchCount) {
        LottoRank findRank = LottoRank.NONE;
        for (LottoRank rank : values()) {
            findRank = findLottoLank(findRank, rank, matchCount);
        }

        return findRank;
    }

    private static LottoRank findLottoLank(LottoRank findRank, LottoRank rank, Long matchCount) {
        if(findRank.isWinning()) {
            return findRank;
        }

        if(rank.isNone()) {
            return findRank;
        }

        if(rank.matchCount != matchCount) {
            return findRank;
        }
        return rank;
    }

    public boolean isNone() {
        return NONE.equals(this);
    }

    public boolean isWinning() {
        return !isNone();
    }

    public static LottoRank minimumLottoRank() {
        return LottoRank.FOURTH_PLACE;
    }

    public long matchCount() {
        return this.matchCount;
    }

    public Money winningMoney() {
        return Money.of(this.winningMoney);
    }

    public Money winningMoneyWithCount(long count) {
        return Money.of(this.winningMoney * count);
    }
}
