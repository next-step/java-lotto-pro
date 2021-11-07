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

    public final static Lottos EMPTY = new Lottos(new ArrayList<>(), new ArrayList<>());

    private final List<Lotto> autoLottos;
    private final List<Lotto> manualLottos;

    public Lottos(List<Lotto> autoLottos, List<Lotto> manualLottos) {
        this.autoLottos = Collections.unmodifiableList(autoLottos);
        this.manualLottos = Collections.unmodifiableList(manualLottos);
    }

    public static Lottos of(Lotto... lottos) {
        return new Lottos(Arrays.asList(lottos), new ArrayList<>());
    }

    public static Lottos of(Lottos autoLottos, Lottos manualLottos) {
        return new Lottos(autoLottos.autoLottos, manualLottos.manualLottos);
    }

    public static Lottos fromAutoLottos(List<Lotto> autoLottos) {
        return new Lottos(autoLottos, new ArrayList<>());
    }
    public static Lottos fromManualLottos(List<Lotto> manualLottos) {
        return new Lottos(new ArrayList<>(), manualLottos);
    }

    public List<Lotto> getAutoLottos() {
        return autoLottos;
    }

    public List<Lotto> getManualLottos() {
        return manualLottos;
    }

    public int getQuantity() {
        return getAutoQuantity() + getManualQuantity();
    }

    public int getAutoQuantity() {
        return autoLottos.size();
    }

    public int getManualQuantity() {
        return manualLottos.size();
    }

    public WinningResults getWinningResults(WinningLotto winningLotto) {
        List<Lotto> mergedLottos = Stream.of(autoLottos, manualLottos)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        return WinningResults.of(mergedLottos, winningLotto);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lottos lottos1 = (Lottos) o;
        return Objects.equals(autoLottos, lottos1.autoLottos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(autoLottos);
    }
}
