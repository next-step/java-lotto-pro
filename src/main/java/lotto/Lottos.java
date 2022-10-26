package lotto;

import java.util.List;

public class Lottos {
    private final List<Lotto> values;

    private Lottos(List<Lotto> values) {
        this.values = values;
    }

    public static Lottos from(List<Lotto> values) {
        return new Lottos(values);
    }

    public int size() {
        return this.values.size();
    }
}
