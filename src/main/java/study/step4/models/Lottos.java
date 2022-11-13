package study.step4.models;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Lottos {
    private List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int size() {
        return lottos.size();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    @Override
    public String toString() {
        return lottos.toString();
    }

    public Map<Rank, Integer> findWinningLottos(WinningLotto winLotto, LottoNumber bonusBall) {
        Map<Rank, Integer> winningLottos = new EnumMap<>(Rank.class);
        for (Lotto lotto : lottos) {
            int numberOfMatching = lotto.countNumberOfMatching(winLotto);
            Rank rank = Rank.valueOf(numberOfMatching, lotto.contains(bonusBall));
            winningLottos.put(rank, winningLottos.getOrDefault(rank, 0) + 1);
        }
        return winningLottos;
    }
}
