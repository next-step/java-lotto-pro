package step3.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getNumbersOfLottos() {
        return lottos;
    }

    public Map<Rank, Integer> getRankOfLottos(Lotto winningLotto) {
        HashMap<Rank, Integer> result = new HashMap<>();
        lottos.forEach(lotto -> {
            Rank rank = lotto.getRank(winningLotto);
            result.put(rank, result.getOrDefault(rank, 0) + 1);
        });
        return result;
    }

    public Map<Rank, Integer> getRankOfLottos(WinningLotto winningLotto) {
        HashMap<Rank, Integer> result = new HashMap<>();
        lottos.forEach(lotto -> {
            Rank rank = lotto.getRank(winningLotto);
            result.put(rank, result.getOrDefault(rank, 0) + 1);
        });
        return result;
    }

}
