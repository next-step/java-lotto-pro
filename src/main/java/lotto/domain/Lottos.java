package lotto.domain;

import lotto.enums.Rank;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private final List<Lotto> lottos = new ArrayList<>();

    public Lottos() {}

    public Lottos(List<Lotto> input) {
        lottos.addAll(input);
    }

    public void add(Lotto lotto) {
        lottos.add(lotto);
    }

    public int count() {
        return lottos.size();
    }

    public WinningStatistic checkWinnings(WinningLotto winning) {
        WinningStatistic statistic = new WinningStatistic();

        for (Lotto lotto : lottos) {
            int matchCount = lotto.match(winning);
            Rank rank = Rank.of(matchCount);

            boolean bonus = winning.matchBonus(lotto);
            statistic.collect(rank.convertSecondPrize(bonus));
        }
        return statistic;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public void merge(Lottos autoLottos) {
        lottos.addAll(autoLottos.lottos);
    }
}
