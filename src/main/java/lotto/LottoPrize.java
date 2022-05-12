package lotto;

import lotto.money.Money;

import java.util.Arrays;
import java.util.function.Predicate;

public enum LottoPrize {
    MISS("미스", matchCount -> matchCount < 3, Money.of(0)),
    THREE_MATCH("3개 일치", matchCount -> matchCount == 3, Money.of(5_000)),
    FOUR_MATCH("4개 일치", matchCount -> matchCount == 4, Money.of(50_000)),
    FIVE_MATCH("5개 일치", matchCount -> matchCount == 5, Money.of(1_500_000)),
    SIX_MATCH("6개 일치", matchCount -> matchCount == 6, Money.of(2_000_000_000));

    private final String description;
    private final Predicate<Integer> matchCondition;
    private final Money prize;

    LottoPrize(String description, Predicate<Integer> matchCondition, Money prize) {
        this.description = description;
        this.matchCondition = matchCondition;
        this.prize = prize;
    }

    public static LottoPrize valueOf(int matchCount) {
        return null;
    }
}
