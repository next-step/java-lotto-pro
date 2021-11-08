package lotto.domain;

import java.util.Iterator;
import java.util.List;

public class Lottos implements Iterable<Lotto> {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int count() {
        return this.lottos.size();
    }

    public Lottos addLottos(Lottos otherLottos) {
        this.lottos.addAll(otherLottos.lottos);
        return new Lottos(this.lottos);
    }

    @Override
    public Iterator<Lotto> iterator() {
        return lottos.iterator();
    }
}
