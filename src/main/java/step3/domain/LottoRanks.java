package step3.domain;

import java.util.Arrays;

public class LottoRanks {
    private static final int MIN_RANK_NUMBER = 3;
    private final LottoRank[] lottoRanks = LottoRank.listOf();

    public void matchOfMatchCount(int matchCount) {
        for (LottoRank lottoRank : lottoRanks) {
            lottoRank.incrementCountHasMatchNumber(matchCount);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        LottoRanks that = (LottoRanks)o;
        return Arrays.equals(lottoRanks, that.lottoRanks);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(lottoRanks);
    }

    public Long totalPrize() {
        long totalPrize = 0L;
        for (LottoRank lottoRank : lottoRanks) {
            totalPrize += lottoRank.totalPrize();
        }
        return totalPrize;
    }

    public double getYield(Amount amount) {
        return (double)(totalPrize() / amount.getAmount());
    }

    public LottoRank[] values() {
        return lottoRanks;
    }
}
