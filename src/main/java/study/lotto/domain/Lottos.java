package study.lotto.domain;

import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;
    private final WinStats stats;

    public Lottos(List<Lotto> allNumbersFromStore) {
        this.lottos = allNumbersFromStore;
        this.stats = new WinStats(lottos.size());
    }

    public WinStats drawLots(WinningLotto winningLotto) {
        return winningLotto.drawLots(this.lottos, stats);
    }

    public String countByOrderType() {
        return getManualCount() + "," + getAutoCount();
    }

    private long getManualCount() {
        return lottos.stream()
                .filter(Lotto::isManual)
                .count();
    }

    private long getAutoCount() {
        return lottos.stream()
                .filter(Lotto::isAuto)
                .count();
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
