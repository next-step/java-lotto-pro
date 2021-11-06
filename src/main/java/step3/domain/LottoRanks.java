package step3.domain;

public class LottoRanks {
    private final LottoRank[] lottoRanks = LottoRank.listOf();

    public void matchOfMatchCount(int matchCount) {
        for (LottoRank lottoRank : lottoRanks) {
            lottoRank.incrementCountHasMatchNumber(matchCount);
        }
    }

    public Long totalPrize() {
        long totalPrize = 0L;
        for (LottoRank lottoRank : lottoRanks) {
            totalPrize += lottoRank.totalPrize();
        }
        return totalPrize;
    }

    public LottoRank[] getLottoRanks() {
        return lottoRanks;
    }
}
