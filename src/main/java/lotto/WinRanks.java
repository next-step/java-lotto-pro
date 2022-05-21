package lotto;

import java.util.HashMap;
import java.util.Map;

public class WinRanks {
<<<<<<< HEAD
    private final Map<Rank, Integer> winTotals;

    public WinRanks() {
        winTotals = new HashMap<>();
        winTotals.put(Rank.FIRST, 0);
        winTotals.put(Rank.SECOND, 0);
        winTotals.put(Rank.THIRD, 0);
        winTotals.put(Rank.FOURTH, 0);
        winTotals.put(Rank.FIFTH, 0);
    }

    public Map<Rank, Integer> getWinTotals() {
        return winTotals;
=======
    private final Map<Rank, Integer> winMap;

    public WinRanks() {
        winMap = new HashMap<>();
        winMap.put(Rank.FIRST, 0);
        winMap.put(Rank.THIRD, 0);
        winMap.put(Rank.FOURTH, 0);
        winMap.put(Rank.FIFTH, 0);
    }

    public Map<Rank, Integer> getWinMap() {
        return winMap;
>>>>>>> 119371d (refactor : Rank enum으로 변경)
    }

    public int winningPrice(Lotto winningLotto, Lottos lottos, int bonusNumber) {
        int totalPrice = 0;
<<<<<<< HEAD
        calculateWinPriceTotals(winningLotto, lottos, bonusNumber);
        for (Rank rankEnum : winTotals.keySet()) {
            totalPrice += winTotals.get(rankEnum) * rankEnum.getWinningMoney();
=======
        calculateWinPriceMap(winningLotto, lottos);
        for (Rank rankEnum : winMap.keySet()) {
            totalPrice += winMap.get(rankEnum) * rankEnum.getWinningMoney();
>>>>>>> 119371d (refactor : Rank enum으로 변경)
        }
        return totalPrice;
    }

    public void calculateWinPriceTotals(Lotto winningLotto, Lottos lottos, int bonusNumber) {
        for (Lotto lotto : lottos.getLottoSheets()) {
            int checkMatchCount = lotto.checkMatchCount(winningLotto);
            boolean bonusMatch = lotto.checkBonusMatch(bonusNumber);
            addRankCount(winTotals, checkMatchCount, bonusMatch);
        }
    }

<<<<<<< HEAD
    private void addRankCount(Map<Rank, Integer> winTotals, int checkMatchCount, boolean bonusMatch) {
        Rank key = Rank.matchedRank(checkMatchCount, bonusMatch);
        if (winTotals.containsKey(key)) {
            winTotals.put(key, winTotals.get(key) + 1);
=======
    private void addRankCount(Map<Rank, Integer> winMap, int checkMatchCount) {
        Rank key = Rank.valueOf(checkMatchCount);
        if (winMap.containsKey(key)) {
            winMap.put(key, winMap.get(key) + 1);
>>>>>>> 119371d (refactor : Rank enum으로 변경)
        }
    }

    public String calulateProfitRate(int profitMoney, int purchaseMoney) {
        final String PROFIT_RATE_FORMAT = "%.2f";
        return String.format(PROFIT_RATE_FORMAT, (double) profitMoney / purchaseMoney);
    }
}