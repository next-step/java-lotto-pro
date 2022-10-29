package study.lotto.domain;

import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;
    private final WinStats stats;

    public Lottos(List<Lotto> allNumbersFromStore) {
        lottos = allNumbersFromStore;
        stats = new WinStats(lottos.size());
    }

    public WinStats drawLots(WinningLotto winningLotto) {
        return winningLotto.drawLots(this.lottos, stats);
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        lottos.forEach((lotto) -> {
            buffer.append(lotto.toString()).append("\n");
        });
        return buffer.toString();
    }
}
