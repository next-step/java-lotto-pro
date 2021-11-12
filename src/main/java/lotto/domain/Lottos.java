package lotto.domain;

import java.util.*;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = Collections.unmodifiableList(lottos);
    }

    public WinningResult winningResult(WinningLotto winningLotto) {
        Map<Rank, Integer> winningResult = new EnumMap<>(Rank.class);

        for (Lotto lotto : lottos) {
            Rank rank = winningLotto.rankResult(lotto);
            winningResultAccumulate(winningResult, rank);
        }
        return new WinningResult(winningResult);
    }

    private void winningResultAccumulate(Map<Rank, Integer> winningResult, Rank rank) {
        if (rank.isPrize()) {
            Integer winsNumberCount = winningResult.computeIfAbsent(rank, key -> 0);
            winningResult.put(rank, winsNumberCount + 1);
        }
    }

    public int purchaseNumber() {
        return this.lottos.size();
    }

    public List<Lotto> purchaseList() {
        return new ArrayList<>(this.lottos);
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
