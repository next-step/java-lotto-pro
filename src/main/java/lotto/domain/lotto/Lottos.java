package lotto.domain.lotto;

import java.util.ArrayList;
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

    public static Lottos fromBy(List<List<Integer>> rawLottos) {
        List<Lotto> values = new ArrayList<>();
        for (List<Integer> lottoNumbers : rawLottos) {
            values.add(Lotto.fromBy(lottoNumbers));
        }
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
