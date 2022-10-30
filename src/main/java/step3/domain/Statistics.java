package step3.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Statistics {

    private final List<Rank> ranks;

    public Statistics(Collection<Rank> ranks) {
        this.ranks = new ArrayList<>(ranks);
    }

    public int count(Rank rank) {
        return (int) ranks.stream()
            .filter(rank::equals)
            .count();
    }

    public BigDecimal totalReward() {
        if(ranks.isEmpty()) {
            return BigDecimal.ZERO;
        }

        int totalReward = ranks.stream().mapToInt(Rank::reward).sum();
        int buyMoney = ranks.size() * 1_000;

        return BigDecimal.valueOf(totalReward)
            .divide(BigDecimal.valueOf(buyMoney), 2, BigDecimal.ROUND_DOWN);
    }
}
