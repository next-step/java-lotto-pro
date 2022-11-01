package step3.domain.statistics;

import step3.domain.lotto.*;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class LottoStatistics {

    private Lottos lottos;
    private Map<Rank, Integer> lottoResult = new HashMap<>();

    public LottoStatistics(Map<Rank, Integer> lottoResult) {
        this.lottoResult = lottoResult;
    }

    public LottoStatistics(Lottos lottos, Map<Rank, Integer> lottoResult) {
        this.lottos = lottos;
        this.lottoResult = lottoResult;
    }

    public LottoStatistics(Lottos lottos, WinningLotto winningLotto) {
        this.lottos = lottos;
        lottoResult(lottos, winningLotto.getWinningLottoNumbers(), winningLotto.getBonusLottoNumber());
    }

    public double getTotalProfit() {
        int totalWinningAmount = getTotalWinningAmount();
        int totalLottoPrice = getTotalLottoPrice(lottos);
        return Math.floor((double) totalWinningAmount / totalLottoPrice * 100) / 100.0;
    }

    public int getTotalWinningAmount() {
        int totalWinningAmount = 0;
        for (Rank rank : lottoResult.keySet()) {
            totalWinningAmount += rank.getWinningAmount() * lottoResult.get(rank);
        }
        return totalWinningAmount;
    }

    public int getTotalLottoPrice(Lottos lottos) {
        return lottos.value().stream()
                .mapToInt(Lotto::getPrice)
                .sum();
    }

    private void lottoResult(Lottos lottos, WinningLottoNumbers winningLottoNumbers, BonusLottoNumber bonusLottoNumber) {
        lottos.value()
                .forEach(lotto -> {
                    Rank type = lotto.getRank(winningLottoNumbers, bonusLottoNumber);
                    lottoResult.put(type, lottoResult.getOrDefault(type, 0) + 1);
                });
    }

    private String getString(Rank rank) {
        if (rank == Rank.SECOND) {
            return getFormat("%d개 일치, 보너스 볼 일치(%d원)- %d개%n", rank);
        }
        return getFormat("%d개 일치 (%d원)- %d개%n", rank);
    }

    private String getFormat(String format, Rank rank) {
        return String.format(format, rank.getMatch().getCount(),
                rank.getWinningAmount(),
                lottoResult.getOrDefault(rank, 0));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Arrays.stream(Rank.values())
                .filter(rank -> rank != Rank.MISS)
                .sorted(Comparator.reverseOrder())
                .forEach(rank -> sb.append(getString(rank)));
        return sb.toString();
    }
}
