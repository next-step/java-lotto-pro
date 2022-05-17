package lotto.domain;

import java.util.List;
import java.util.Objects;

public class Lottos {

    private List<Lotto> elements;
    private WinningStatistics winningStatistics;

    public Lottos(List<Lotto> elements) {
        this.elements = elements;
        this.winningStatistics = new WinningStatistics();
    }

    public void makeWinningResult(Lotto winningLotto) {
        for (Lotto lotto : elements) {
            winningStatistics.addLottoRanking(LottoRanking.findLottoRaking(lotto, winningLotto));
        }
    }

    public double calculateRateOfReturn(int purchaseAmount) {
        return winningStatistics.calculateRateOfReturn(purchaseAmount);
    }

    public List<Lotto> getElements() {
        return elements;
    }

    public WinningStatistics getWinningStatistics() {
        return winningStatistics;
    }

    @Override

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lottos lottos = (Lottos) o;
        return Objects.equals(elements, lottos.elements);
    }

    @Override
    public int hashCode() {
        return Objects.hash(elements);
    }
}
