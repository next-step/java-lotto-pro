package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Lottos {

    private List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public WinningResult winningResult(List<Integer> winningNumbers) {
        Map<Integer, Integer> winningResult = new HashMap<>();

        for (Lotto lotto : lottos) {
            int winningNumberMatchCount = lotto.winningNumberMatchCount(winningNumbers);
            winningResultAccumulate(winningResult, winningNumberMatchCount);
        }
        return new WinningResult(winningResult);
    }

    private void winningResultAccumulate(Map<Integer, Integer> winningResult, int winningNumberMatchCount) {
        if (winningResult.putIfAbsent(winningNumberMatchCount, 0) == null) {
            winningResult.put(winningNumberMatchCount, winningResult.get(winningNumberMatchCount) + 1);
        }
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
