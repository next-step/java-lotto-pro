package step4.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos() {
        this.lottos = new ArrayList<>();
    }

    public Lottos(Lotto lotto) {
        this.lottos = Stream.of(lotto).collect(Collectors.toList());
    }

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public Lottos plus(Lottos otherLottos) {
        return new Lottos(
                Stream.concat(lottos.stream(), otherLottos.lottos.stream())
                        .collect(Collectors.toList())
        );
    }

    public int count() {
        return this.lottos.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lottos lottos1 = (Lottos) o;
        return lottos.equals(lottos1.lottos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottos);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        lottos.forEach(lotto ->
                builder.append(lotto.toString()).append("\n")
        );
        return builder.toString();
    }

    public int matchCountAboutRank(WinningLotto winningLotto, Rank rank) {
        return (int) lottos.stream().filter(lotto -> winningLotto.match(lotto).equals(rank)).count();
    }
}
