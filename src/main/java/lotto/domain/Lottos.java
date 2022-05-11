package lotto.domain;

import java.util.Collections;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos from(List<Lotto> lottos){
        return new Lottos(lottos);
    }

    public List<Lotto> getReadOnlyLottos() {
        return Collections.unmodifiableList(this.lottos);
    }

    public int getCount() {
        return this.lottos.size();
    }
}
