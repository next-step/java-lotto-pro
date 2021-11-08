package lotto.domain;

public class LottoResult {
    private final int matchAmount;
    private final boolean matchBonus;

    public LottoResult(int matchAmount) {
        this(matchAmount, false);
    }

    public LottoResult(int matchAmount, boolean matchBonus) {
        this.matchAmount = matchAmount;
        this.matchBonus = matchBonus;
    }

    public LottoRankingStatus getResultRankingStatus() {
        return LottoRankingStatus.valueOf(matchAmount, matchBonus);
    }
}
