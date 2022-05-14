package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private final List<Lotto> lottos = new ArrayList<>();

    public void add(Lotto lotto) {
        lottos.add(lotto);
    }

    public int count() {
        return lottos.size();
    }

    public WinningStatistic checkWinnings(Lotto winning) {
        WinningStatistic statistic = new WinningStatistic();

        for (Lotto lotto : lottos) {
            int matchCount = lotto.match(winning);
            Rank rank = Rank.of(matchCount);

            statistic.collect(rank);
        }
        return statistic;
    }
}
