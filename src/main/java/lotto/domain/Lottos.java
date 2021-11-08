package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lottos {

    public final static Lottos EMPTY = new Lottos(new ArrayList<>());

    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = Collections.unmodifiableList(lottos);
    }

    public static Lottos from(List<Lotto> lottos) {
        return new Lottos(lottos);
    }

    public static Lottos of(Lotto... lottos) {
        return new Lottos(Arrays.asList(lottos));
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int getTotalQuantity() {
        return lottos.size();
    }

    public int getAutoQuantity() {
        return getTotalQuantity() - getManualQuantity();
    }

    public int getManualQuantity() {
        return (int) lottos.stream()
                .filter(Lotto::isManual)
                .count();
    }

    public WinningResults getWinningResults(WinningLotto winningLotto) {
        return WinningResults.of(lottos, winningLotto);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lottos lottos1 = (Lottos) o;
        return Objects.equals(lottos, lottos1.lottos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottos);
    }
}
