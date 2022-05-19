package lotto.domain;

import java.util.List;
import java.util.Objects;

public class Lottos {

    private List<Lotto> elements;

    public Lottos(List<Lotto> elements) {
        this.elements = elements;
    }

    public void makeWinningResult(Lotto winningLotto, WinningStatistics winningStatistics) {
        for (Lotto lotto : elements) {
            winningStatistics.addLottoRanking(LottoRanking.findLottoRaking(lotto, winningLotto));
        }
    }


    public List<Lotto> getElements() {
        return elements;
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
