package step3.domain.statistics;

import step3.domain.lotto.Lotto;
import step3.domain.lotto.Lottos;
import step3.domain.lotto.WinningLottoNumbers;

import java.util.HashMap;
import java.util.Map;

public class LottoStatistics {

    private Lottos lottos;
    private Map<WinningLottoType, Integer> lottoResult = new HashMap<>();

    public LottoStatistics(Map<WinningLottoType, Integer> lottoResult) {
        this.lottoResult = lottoResult;
    }

    public LottoStatistics(Lottos lottos, Map<WinningLottoType, Integer> lottoResult) {
        this.lottos = lottos;
        this.lottoResult = lottoResult;
    }

    public LottoStatistics(Lottos lottos, WinningLottoNumbers winningLottoNumbers) {
        this.lottos = lottos;
        lottos.getLottos()
                .forEach(lotto -> {
                    WinningLottoType type = lotto.getWinningLottoType(winningLottoNumbers);
                    lottoResult.put(type, lottoResult.getOrDefault(type, 0) + 1);
                });
    }

    public double getTotalProfit() {
        int totalWinningAmount = getTotalWinningAmount();
        int totalLottoPrice = getTotalLottoPrice(lottos);
        return Math.floor((double) totalWinningAmount / totalLottoPrice * 100) / 100.0;
    }

    public int getTotalWinningAmount() {
        int totalWinningAmount = 0;
        for (WinningLottoType winningLottoType : lottoResult.keySet()) {
            Integer count = lottoResult.get(winningLottoType);
            totalWinningAmount += winningLottoType.getWinningAmount() * count;
        }
        return totalWinningAmount;
    }

    public static int getTotalLottoPrice(Lottos lottos) {
        return lottos.getLottos().stream()
                .mapToInt(Lotto::getPrice)
                .sum();
    }

    public Map<WinningLottoType, Integer> getLottoResult() {
        return lottoResult;
    }

    @Override
    public String toString() {
        return "LottoStatistics{" +
                "lottoResult=" + lottoResult +
                '}';
    }
}
