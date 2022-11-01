package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Lottos {

    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos of(List<Lotto> lottos) {
        return new Lottos(lottos);
    }

    public static Lottos autoGenerateSizeOf(int size) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            lottos.add(Lotto.of(LottoNumbers.generate()));
        }
        return new Lottos(lottos);
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }

    public int size() {
        return lottos.size();
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (!(o instanceof Lottos)) return false;
        Lottos lottos1 = (Lottos) o;
        return Objects.equals(lottos, lottos1.lottos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottos);
    }
}
