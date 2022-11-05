package lotto.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Statistics {

    private static final int DECIMAL_PLACES = 2;

    private final List<Rank> ranks;

    public Statistics(Collection<Rank> ranks) {
        this.ranks = new ArrayList<>(ranks);
    }

    public int count(Rank rank) {
        return (int) ranks.stream().filter(rank::equals).count();
    }

    public BigDecimal totalReward() {
        if (ranks.isEmpty()) {
            return BigDecimal.ZERO;
        }

        long totalReward = ranks.stream().mapToLong(Rank::reward).reduce(0L, Long::sum);
        int buyMoney = ranks.size() * 1_000;

        return BigDecimal.valueOf(totalReward)
            .divide(BigDecimal.valueOf(buyMoney), DECIMAL_PLACES, BigDecimal.ROUND_DOWN);
    }
}
