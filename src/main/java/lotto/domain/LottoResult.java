package lotto.domain;

public class LottoResult {
    private final int matchAmount;

    public LottoResult(int matchAmount) {
        this.matchAmount = matchAmount;
    }

    public LottoRankingStatus getResultRankingStatus() {
        return LottoRankingStatus.getLottoRankingFromMatchAmount(matchAmount);
    }
}
