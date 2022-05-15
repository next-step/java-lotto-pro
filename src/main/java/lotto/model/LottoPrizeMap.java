package lotto.model;

import java.util.Map;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static lotto.model.LottoPrizeRank.MISS;

public class LottoPrizeMap {
    public static Map<Integer, Long> of(LottoPrizeRanks lottoPrizeRanks) {
        return toMap(lottoPrizeRanks);
    }

    private static Map<Integer, Long> toMap(LottoPrizeRanks lottoPrizeRanks) {
        return lottoPrizeRanks.getLottoPrizeRanks().stream()
                .filter(rank -> !rank.equals(MISS))
                .collect(groupingBy(LottoPrizeRank::getNumberOfMatch, counting()));
    }
}
