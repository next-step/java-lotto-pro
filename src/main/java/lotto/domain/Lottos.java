package lotto.domain;

import java.util.*;

public class Lottos {

    private List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public WinningResult winningResult(Lotto winningNumber, LottoNumber bonusNumber) {
        Map<Rank, Integer> winningResult = new EnumMap<>(Rank.class);

        for (Lotto lotto : lottos) {
            WinningNumberMatchResult winningNumberMatchResult = lotto.winningNumberMatch(winningNumber, bonusNumber);
            Rank rank = winningNumberMatchResult.rank();
            if (rank.isPrize()) {
                winningResultAccumulate(winningResult, rank);
            }
        }
        return new WinningResult(winningResult);
    }

    private void winningResultAccumulate(Map<Rank, Integer> winningResult, Rank rank) {
        if (winningResult.putIfAbsent(rank, 0) == null) {
            winningResult.put(rank, winningResult.get(rank) + 1);
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
