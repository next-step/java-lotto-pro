package lotto;

import java.util.Arrays;
import java.util.function.Predicate;

public enum LottoPrize {
    MISS("미스", matchCount -> matchCount < 3, 0),
    THREE_MATCH("3개 일치", matchCount -> matchCount == 3, 5_000),
    FOUR_MATCH("4개 일치", matchCount -> matchCount == 4, 50_000),
    FIVE_MATCH("5개 일치", matchCount -> matchCount == 5, 1_500_000),
    SIX_MATCH("6개 일치", matchCount -> matchCount == 6, 2_000_000_000);

    private final String description;
    private final Predicate<Integer> matchCondition;
    private final long prizeMoneyValue;

    LottoPrize(String description, Predicate<Integer> matchCondition, long prizeMoneyValue) {
        this.description = description;
        this.matchCondition = matchCondition;
        this.prizeMoneyValue = prizeMoneyValue;
    }

    public long prizeMoneyValue() {
        return prizeMoneyValue;
    }

    public static LottoPrize valueOf(int matchCount) {
        return Arrays.stream(values())
                     .filter(it -> it.matchCondition.test(matchCount))
                     .findFirst()
                     .orElse(MISS);
    }
}
