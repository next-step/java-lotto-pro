package lotto.domain.lotto;

import java.util.Collections;
import java.util.List;

public class Lottos {
    private final List<Lotto> values;

    private Lottos(List<Lotto> values) {
        this.values = values;
    }

    public static Lottos from(List<Lotto> values) {
        return new Lottos(values);
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(values);
    }

    public int size() {
        return values.size();
    }

    public Lottos add(Lottos lottos) {
        this.values.addAll(lottos.getLottos());
        return Lottos.from(this.values);
    }
}
