package lotto.model.lotto.enums;

public enum LottoRank {
    FIRST(LottoNumberMatchCount.SIX, 2_000_000_000),
    SECOND(LottoNumberMatchCount.FIVE, 150_000),
    THIRD(LottoNumberMatchCount.FOUR, 50_000),
    FOURTH(LottoNumberMatchCount.THREE, 5_000);

    private final LottoNumberMatchCount matchCount;
    private final int prizeMoney;

    LottoRank(LottoNumberMatchCount matchCount, int prizeMoney) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
    }

    public LottoNumberMatchCount matchCount() {
        return matchCount;
    }

    public int prizeMoney() {
        return prizeMoney;
    }
}
