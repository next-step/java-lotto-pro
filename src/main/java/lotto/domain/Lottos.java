package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
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

    public List<Integer> getMatchingCounts(final Lotto winningLotto) {
        List<Integer> matchingCounts = new ArrayList<>();
        for (Lotto lotto : lottos) {
            matchingCounts.add(winningLotto.countMatchingNumber(lotto));
        }
        return matchingCounts;
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }

}
