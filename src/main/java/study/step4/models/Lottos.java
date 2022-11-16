package study.step4.models;

import study.step4.exception.LottoNumberDuplicateException;

import java.util.EnumMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        validateDifferentLotto(lottos);
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

    private void validateDifferentLotto(List<Lotto> lottos) {
        if (hasDuplicateLotto(lottos)) {
            throw new LottoNumberDuplicateException("로또는 중복될 수 없습니다.");
        }
    }

    private boolean hasDuplicateLotto(List<Lotto> lottos) {
        return lottos.size() != new HashSet<>(lottos).size();
    }

    public boolean contains(Lotto lotto) {
        return lottos.contains(lotto);
    }

    public Map<Rank, Integer> findWinningLottos(WinningLotto winningLotto) {
        Map<Rank, Integer> winningLottos = new EnumMap<>(Rank.class);
        for (Lotto lotto : lottos) {
            int numberOfMatching = lotto.countNumberOfMatching(winningLotto);
            Rank rank = Rank.valueOf(numberOfMatching, winningLotto.hasBonusBall(lotto));
            winningLottos.put(rank, winningLottos.getOrDefault(rank, 0) + 1);
        }
        return winningLottos;
    }
}
