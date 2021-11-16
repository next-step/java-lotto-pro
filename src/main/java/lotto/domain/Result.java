package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Result {

    private static final int PRIZE_COUNT_UNIT = 1;
    private static final int NO_PRIZE = 0;

    private final Map<Prize, Integer> prizes = new EnumMap<>(Prize.class);

    public Result(List<Prize> resultPrizes) {
        for (Prize prize : resultPrizes) {
            putPrize(prize);
        }
    }

    private void putPrize(final Prize prize) {
        if (this.prizes.containsKey(prize)) {
            final Integer prizeCount = this.prizes.get(prize);
            this.prizes.put(prize, prizeCount + PRIZE_COUNT_UNIT);
        }
        this.prizes.putIfAbsent(prize, PRIZE_COUNT_UNIT);
    }

    public int getNumberOfPrizes(final Prize prize) {
        return prizes.getOrDefault(prize, NO_PRIZE);
    }

    public double calculateReturnOnInvestment() {
        final long totalPrize = calculateTotalPrizeAmount().getValue();
        final int numberOfPlayslips = prizes.values().stream().mapToInt(Integer::intValue).sum();
        final long investedAmount = new Price(numberOfPlayslips).getValue();
        return (double) totalPrize / investedAmount;
    }

    private Price calculateTotalPrizeAmount() {
        Price p = new Price(0L);
        for (Map.Entry<Prize, Integer> entry : prizes.entrySet()) {
            final Prize prize = entry.getKey();
            final Integer numberOfPrizes = entry.getValue();
            p = p.add(prize.getAmount().multiply(numberOfPrizes));
        }
        return p;
    }
}
