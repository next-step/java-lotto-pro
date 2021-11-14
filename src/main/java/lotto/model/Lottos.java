package lotto.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import lotto.model.enums.Rank;

public class Lottos {
    private final Collection<Lotto> lottos;

    Lottos(Lotto... lottos) {
        this(Arrays.stream(lottos)
            .collect(Collectors.toList()));
    }

    Lottos(Collection<Lotto> lottos) {
        this.lottos = Objects.requireNonNull(lottos);
    }

    public static Lottos newInstance(int lottoCount, Supplier<Collection<Integer>> numberSupplier) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            Lotto lotto = new Lotto(numberSupplier.get());
            lottos.add(lotto);
        }
        return new Lottos(lottos);
    }

    public static Lottos empty() {
        return new Lottos(new ArrayList<>());
    }

    public Lottos combine(Lottos other) {
        ArrayList<Lotto> lottos = new ArrayList<>(this.lottos);
        lottos.addAll(other.getLottos());
        return new Lottos(lottos);
    }

    private Collection<Lotto> getLottos() {
        return lottos;
    }

    public Collection<Rank> computeRanks(Number bonusNumber, Lotto winningLotto) {
        Objects.requireNonNull(bonusNumber);
        Objects.requireNonNull(winningLotto);

        List<Rank> ranks = new ArrayList<>();
        for (Lotto lotto : lottos) {
            Rank rank = lotto.computeRank(bonusNumber, winningLotto);
            ranks.add(rank);
        }
        return ranks;
    }

    public boolean isEmpty() {
        return lottos.isEmpty();
    }

    public int size() {
        return lottos.size();
    }

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner(System.lineSeparator());
        for (Lotto lotto : lottos) {
            stringJoiner.add(lotto.toString());
        }
        return stringJoiner.toString();
    }
}
