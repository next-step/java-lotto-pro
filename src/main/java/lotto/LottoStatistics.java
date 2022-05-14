package lotto;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoStatistics {
    public static final int PROFIT_ROUND_INDEX = 2;
    private final List<WinningRank> winningRanks;
    private final LottoPrice lottoPrice;

    public LottoStatistics(List<WinningRank> winningRanks, LottoPrice lottoPrice) {
        this.winningRanks = winningRanks;
        this.lottoPrice = lottoPrice;
    }

    public Map<WinningRank, Integer> getCountByWinningRank() {
        EnumMap<WinningRank, Integer> result = new EnumMap<>(WinningRank.class);

        for (WinningRank winningRank : winningRanks) {
            Integer count = result.getOrDefault(winningRank, 0);
            result.put(winningRank, count + 1);
        }

        return result;
    }

    public double calculateProfit() {
        double profile = calculatePrize() / (double) lottoPrice.getPrice();
        return MathUtils.round(profile, PROFIT_ROUND_INDEX);
    }

    private long calculatePrize() {
        long prize = 0;

        for (WinningRank winningRank : winningRanks) {
            prize += winningRank.price;
        }

        return prize;
    }
}
