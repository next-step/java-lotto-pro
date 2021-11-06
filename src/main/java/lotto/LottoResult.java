package lotto;

public class LottoResult {
    private final int matchAmount;

    public LottoResult(int matchAmount) {
        this.matchAmount = matchAmount;
    }

    public LottoRankingStatus getResultRanking() {
        return LottoRankingStatus.getLottoRankingFromMatchAmount(matchAmount);
    }
}
