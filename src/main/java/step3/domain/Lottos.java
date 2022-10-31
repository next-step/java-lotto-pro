package step3.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import step3.enums.Rank;

public class Lottos {

    private List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = new ArrayList<>(lottos);
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }

    public Map<Integer, Integer> calculateWinningBallsEachLotto(WinningLotto winningLotto) {
        Map<Integer, Integer> statistics = Rank.initRank();
        lottos.forEach(lotto -> {
            Rank rank = lotto.match(winningLotto);
            if (rank == Rank.SECOND) {
                statistics.computeIfPresent(Rank.SECOND.getCount()+2, (k, v) -> v + 1);
                return;
            }
            statistics.computeIfPresent(rank.getCount(), (k, v) -> v + 1);
        });
        return statistics;
    }

    public void unionLottos(List<Lotto> manual, List<Lotto> auto) {
        ArrayList<Lotto> merge = new ArrayList<>();
        merge.addAll(manual);
        merge.addAll(auto);
        this.lottos = merge;
    }

    @Override
    public String toString() {
        return lottos.toString();
    }
}
