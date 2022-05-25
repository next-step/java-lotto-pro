package lotto;

import java.util.HashMap;
import java.util.Map;

public class WinRanks {
    private final Map<Rank, Integer> winTotals;

    public WinRanks() {
        winTotals = new HashMap<>();
        winTotals.put(Rank.FIRST, 0);
        winTotals.put(Rank.THIRD, 0);
        winTotals.put(Rank.FOURTH, 0);
        winTotals.put(Rank.FIFTH, 0);
    }

    public Map<Rank, Integer> getWinTotals() {
        return winTotals;
    }

    public int winningPrice(Lotto winningLotto, Lottos lottos) {
        int totalPrice = 0;
        calculateWinPriceTotals(winningLotto, lottos);
        for (Rank rankEnum : winTotals.keySet()) {
            totalPrice += winTotals.get(rankEnum) * rankEnum.getWinningMoney();
        }
        return totalPrice;
    }

    public void calculateWinPriceTotals(Lotto winningLotto, Lottos lottos) {
        for (Lotto lotto : lottos.getLottoSheets()) {
            int checkMatchCount = lotto.checkMatchCount(winningLotto);
            addRankCount(winTotals, checkMatchCount);
        }
    }

    private void addRankCount(Map<Rank, Integer> winTotals, int checkMatchCount) {
        Rank key = Rank.valueOf(checkMatchCount);
        if (winTotals.containsKey(key)) {
            winTotals.put(key, winTotals.get(key) + 1);
        }
    }

    public String calulateProfitRate(int profitMoney, int purchaseMoney) {
        final String PROFIT_RATE_FORMAT = "%.2f";
        return String.format(PROFIT_RATE_FORMAT, (double) profitMoney / purchaseMoney);
    }
}