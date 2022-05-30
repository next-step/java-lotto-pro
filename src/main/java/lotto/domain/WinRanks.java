package lotto.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class WinRanks {
    private Map<Rank, Integer> winTotals;

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
    }

    public int winningPrice(Lotto winningLotto, Lottos lottos, LottoNo bonusNumber) {
        int totalPrice = 0;
        calculateWinPriceTotals(winningLotto, lottos, bonusNumber);
        for (Rank rankEnum : winTotals.keySet()) {
            totalPrice += winTotals.get(rankEnum) * rankEnum.getWinningMoney();
        }
        return totalPrice;
    }

    public void calculateWinPriceTotals(Lotto winningLotto, Lottos lottos, LottoNo bonusNumber) {
        for (Lotto lotto : lottos.getLottoSheets()) {
            int matchCount = lotto.calculateMatchCount(winningLotto);
            boolean bonusMatch = lotto.containsLottoNo(bonusNumber);
            addRankCount(matchCount, bonusMatch);
        }
    }

    private void addRankCount(int checkMatchCount, boolean bonusMatch) {
        Arrays.stream(Rank.values())
                .filter(rank -> checkMatchCount == rank.getCountOfMatch())
                .filter(rank -> bonusMatch == rank.isBonusMatch() || !rank.isBonusMatch()).findFirst()
                .ifPresent(rank -> winTotals.put(rank, winTotals.get(rank) + 1));
    }

    public double calulateProfitRate(int profitMoney, int purchaseMoney) {
        return (double) profitMoney / purchaseMoney;
    }
}