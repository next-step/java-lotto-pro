package lotto.model;

import java.util.List;
import java.util.Objects;

public class LottoPrizeRanks {
    private final List<LottoPrizeRank> lottoPrizeRanks;

    public LottoPrizeRanks(List<LottoPrizeRank> lottoPrizeRankList) {
        this.lottoPrizeRanks = lottoPrizeRankList;
    }

    public List<LottoPrizeRank> getLottoPrizeRanks() {
        return lottoPrizeRanks;
    }

    public float calculate() {
        return lottoPrizeRanks.stream()
                .map(LottoPrizeRank::getPrize)
                .mapToInt(i -> i)
                .sum();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoPrizeRanks that = (LottoPrizeRanks) o;
        return Objects.equals(lottoPrizeRanks, that.lottoPrizeRanks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoPrizeRanks);
    }

    @Override
    public String toString() {
        return "LottoPrizeRanks{" +
                "lottoPrizeRanks=" + lottoPrizeRanks +
                '}';
    }
}
