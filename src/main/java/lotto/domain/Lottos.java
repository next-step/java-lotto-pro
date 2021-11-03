package lotto.domain;

import java.util.EnumMap;
import java.util.List;

public final class Lottos {

    private final List<Lotto> lottos;

    private Lottos(final List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos from(final List<Lotto> lottos) {
        return new Lottos(lottos);
    }

    public int count() {
        return lottos.size();
    }

    public void findRank(final EnumMap<Rank, Integer> result, final Lotto winningLotto) {
        for (Lotto lotto : lottos) {
            int matchingCount = winningLotto.countMatchingNumber(lotto);
            Rank findedRank = Rank.findRank(matchingCount);
            result.put(findedRank, result.getOrDefault(findedRank, 0) + 1);
        }
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }

}
