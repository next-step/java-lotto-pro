package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Lottos {
    private final List<Lotto> values;

    public Lottos() {
        this(new ArrayList<>());
    }

    public Lottos(List<Lotto> lottos) {
        this.values = new ArrayList<>(lottos);
    }

    public void add(Lotto lotto) {
        this.values.add(lotto);
    }

    public List<Lotto> getValues() {
        return Collections.unmodifiableList(values);
    }

    public LottoResult getLottoResult(WinningNumber winningNumber) {
        return new LottoResult(values, winningNumber);
    }

    public int size() {
        return values.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lottos lottos1 = (Lottos) o;
        return Objects.equals(values, lottos1.values);
    }

    @Override
    public int hashCode() {
        return Objects.hash(values);
    }

    @Override
    public String toString() {
        return "Lottos{" +
                "lottos=" + values +
                '}';
    }
}
