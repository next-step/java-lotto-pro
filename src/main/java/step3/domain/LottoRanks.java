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

    public Long totalPrize() {
        long totalPrize = 0L;
        for (LottoRank lottoRank : lottoRanks) {
            totalPrize += lottoRank.totalPrize();
        }
        return totalPrize;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (LottoRank lottoRank : lottoRanks) {
            if (lottoRank.matchNumber >= MIN_RANK_NUMBER) {
                sb.append(lottoRank.toString()).append("\n");
            }
        }
        return sb.toString();
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
}
