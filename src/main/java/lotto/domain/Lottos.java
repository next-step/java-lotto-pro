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
    private final int manualQuantity;

    public Lottos(List<Lotto> lottos, int manualQuantity) {
        this.lottos = Collections.unmodifiableList(lottos);
        this.manualQuantity = manualQuantity;
    }

    public static Lottos of(Lotto... lottos) {
        return new Lottos(Arrays.asList(lottos), 0);
    }

    public static Lottos of(Lottos autoLottos, Lottos manualLottos) {
        return Stream.of(manualLottos.lottos, autoLottos.lottos)
                .flatMap(Collection::stream)
                .collect(Collectors.collectingAndThen(
                        Collectors.toList(), lottos1 -> new Lottos(lottos1, manualLottos.getQuantity())));
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int getManualQuantity() {
        return manualQuantity;
    }

    public int getQuantity() {
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
