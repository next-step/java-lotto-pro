package step3.domain.statistics;

import step3.domain.lotto.Lotto;
import step3.domain.lotto.Lottos;
import step3.domain.lotto.WinningLottoNumbers;

import java.util.HashMap;
import java.util.Map;

public class LottoStatistics {

    private final Map<WinningLottoType, Integer> lottoResult = new HashMap<>();

    public LottoStatistics(Lottos lottos, WinningLottoNumbers winningLottoNumbers) {
        lottos.getLottos()
                .forEach(lotto -> {
                    WinningLottoType type = lotto.getWinningLottoType(winningLottoNumbers);
                    lottoResult.put(type, lottoResult.getOrDefault(type, 0) + 1);
                });
    }

    public static double totalProfit(Lottos lottos, Map<WinningLottoType, Integer> lottoResult) {
        int totalWinningAmount = getTotalWinningAmount(lottoResult);
        int totalLottoPrice = getTotalLottoPrice(lottos);
        return Math.floor((double) totalWinningAmount / totalLottoPrice * 100) / 100.0;
    }

    public static int getTotalWinningAmount(Map<WinningLottoType, Integer> lottoResult) {
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
}
