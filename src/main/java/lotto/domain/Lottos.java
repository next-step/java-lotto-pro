package lotto.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public Stream<Lotto> stream() {
        return this.lottos.stream();
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
