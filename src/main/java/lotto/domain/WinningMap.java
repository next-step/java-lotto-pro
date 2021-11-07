package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class WinningMap {
    private final Map<Rank, Integer> winningMap;

    private WinningMap(final Map<Rank, Integer> winningMap) {
        this.winningMap = winningMap;
    }

    public static WinningMap winningOf(final LottoTicket lottoTicket, final Winning winning) {
        LottoNumbers winningNumbers = winning.getWinningNumbers();
        LottoNumber bonusNumber = winning.getBonusNumber();
        WinningMap winningMap = new WinningMap(new HashMap<>());

        for (LottoNumbers lottoNumbers : lottoTicket.getTicket()) {
            Rank rank = lottoNumbers.hit(winningNumbers, bonusNumber);
            winningMap.countNotMissRank(rank);
        }
        return winningMap;
    }

    private void countNotMissRank(Rank rank) {
        if (rank.isNotMiss()) {
            winningMap.put(rank, winningMap.getOrDefault(rank, 1));
        }
    }


    private int totalWinningAmount() {
        return winningMap.keySet()
                .stream()
                .mapToInt(rank -> rank.calculateRevenue(winningMap.getOrDefault(rank, 0)))
                .sum();
    }

    public Map<Rank, Integer> getWinningMap() {
        return winningMap;
    }

    public double revenue(BoughtLotto boughtLotto) {
        return totalWinningAmount() / (double) boughtLotto.getBoughtMoney();
    }


}
