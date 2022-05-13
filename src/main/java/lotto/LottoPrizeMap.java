package lotto;

import java.util.Map;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static lotto.LottoPrizeRank.NONE;

public class LottoPrizeMap {
    public static Map<Integer, Long> of(LottoPrizeRanks lottoPrizeRanks) {
        return toMap(lottoPrizeRanks);
    }

    private static Map<Integer, Long> toMap(LottoPrizeRanks lottoPrizeRanks) {
        return lottoPrizeRanks.getLottoPrizeRanks().stream()
                .filter(rank -> !rank.equals(NONE))
                .collect(groupingBy(LottoPrizeRank::getNumberOfMatch, counting()));
    }
}
