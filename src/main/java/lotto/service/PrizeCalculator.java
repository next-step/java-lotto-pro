package lotto.service;

import java.util.Map;
import java.util.Map.Entry;
import lotto.domain.Prize;

public class PrizeCalculator {
    public static double returnOfRatio(final int payment, final Map<Prize, Integer> prizeMap) {
        final long income = sumPrizes(prizeMap);
        return Double.valueOf(income) / Double.valueOf(payment);
    }

    private static long sumPrizes(final Map<Prize, Integer> prizeMap) {
        long sum = 0;
        for (Entry<Prize, Integer> entry : prizeMap.entrySet()) {
            sum += entry.getKey().getPrize() * entry.getValue();
        }
        return sum;
    }
}
