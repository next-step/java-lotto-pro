package step3.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import step3.enums.Award;

public class Lottos {

    private List<Lotto> lottos;

    public Lottos() {
    }

    public Lottos(List<Lotto> lottos) {
        this.lottos = new ArrayList<>(lottos);
    }

    public List<Lotto> generateLottos(int count) {
        lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(new Lotto());
        }
        return lottos;
    }

    public void matchWinningNumbers(WinningLotto winningLotto) {
        lottos.forEach(lotto -> {
            lotto.match(winningLotto);
        });
    }

    public Map<Integer, Integer> calculateWinningBallsEachLotto() {
        Map<Integer, Integer> statistics = Award.initRank();
        lottos.forEach(lotto -> {
            if (isBonus(lotto)) {
                statistics.computeIfPresent(Award.FIVE.getCount() + Award.BONUS.getCount(), (k, v) -> v + 1);
                return;
            }
            statistics.computeIfPresent(lotto.getMatchCount(), (k, v) -> v + 1);
        });
        return statistics;
    }

    public void unionLottos(List<Lotto> manual, List<Lotto> auto) {
        ArrayList<Lotto> merge = new ArrayList<>();
        merge.addAll(manual);
        merge.addAll(auto);
        this.lottos = merge;
    }

    private boolean isBonus(Lotto lotto) {
        return lotto.getMatchCount() == Award.FIVE.getCount() && lotto.hasBonusNumber();
    }

}
