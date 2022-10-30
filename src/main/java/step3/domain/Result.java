package step3.domain;

import java.util.EnumMap;
import java.util.Map;

public class Result {
    private Map<Rank, Integer> results;
    private static final int DEFAULT_RANK_COUNT = 0;

    public Result(Lottos lottos, Lotto winningsLotto) {
        init();
        for (Lotto lotto : lottos.getLottoList()) {
            Rank rank = lotto.matches(winningsLotto);
            int count = results.getOrDefault(rank, DEFAULT_RANK_COUNT);
            results.put(rank, count + 1);
        }

        results.remove(Rank.NOTHING);
    }

    private void init() {
        results = new EnumMap<>(Rank.class);

        for (Rank rank : Rank.values()) {
            results.put(rank, DEFAULT_RANK_COUNT);
        }
    }

    public int getTotalWinning() {
        int winningMoney = 0;
        for (Rank rank : results.keySet()) {
            winningMoney += rank.winnings() * results.get(rank);
        }
        return winningMoney;
    }

    public int getCountBy(Rank rank) {
        return results.get(rank);
    }
}
