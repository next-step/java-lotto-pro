package lotto.domain;

import java.util.*;

public class Winners {
    private static final Prize[] RANK = {Prize.FOURTH_PLACE, Prize.THIRD_PLACE, Prize.SECOND_PLACE, Prize.BONUS_PLACE, Prize.FIRST_PLACE};
    private final List<Prize> winners;

    public Winners(List<Prize> prizes) {
        this.winners = prizes;
    }

    public List<Prize> getWinners() {
        return Collections.unmodifiableList(winners);
    }

    public Map<Prize, Long> getRankCount() {
        Map<Prize, Long> eachPrize = new LinkedHashMap<>();
        for (Prize prize : RANK) {
            eachPrize.put(prize, eachCount(prize));
        }
        return eachPrize;
    }

    private long eachCount(final Prize rank) {
        return winners.stream()
                .filter(v -> v.equals(rank))
                .count();
    }

    public long totalPrize(final Map<Prize, Long> eachPrize) {
        long totalPrize = 0;
        for (Prize prize : eachPrize.keySet()) {
            totalPrize += prize.getPrize() * eachPrize.get(prize);
        }
        return totalPrize;
    }

    @Override
    public String toString() {
        return "Winners{" +
                "winners=" + winners +
                '}';
    }
}
