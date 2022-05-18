package lotto.domain;

import java.util.Collections;
import java.util.List;

public class Winners {
    private final List<Prize> winners;

    public Winners(List<Prize> prizes) {
        this.winners = prizes;
    }

    public List<Prize> getWinners() {
        return Collections.unmodifiableList(winners);
    }

    public long countEachPrize(final Prize rank) {
        return winners.stream()
                .filter(v -> v.equals(rank))
                .count();
    }
}
