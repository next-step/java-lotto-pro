package lotto.domain;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = Collections.unmodifiableList(lottos);
    }

    public static Lottos of(Lotto... lottos) {
        return new Lottos(Arrays.asList(lottos));
    }

    public static Lottos of(Lottos manualLottos, Lottos autoLottos) {
        return Stream.of(manualLottos.lottos, autoLottos.lottos)
                .flatMap(Collection::stream)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Lottos::new));
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int size() {
        return lottos.size();
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
