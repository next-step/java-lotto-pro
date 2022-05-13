package lotto;

import lotto.money.Money;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public enum LottoPrize {
    MISS("미스", matchCount -> matchCount < 3, Money.of(0)),
    THREE_MATCH("3개 일치", matchCount -> matchCount == 3, Money.of(5_000)),
    FOUR_MATCH("4개 일치", matchCount -> matchCount == 4, Money.of(50_000)),
    FIVE_MATCH("5개 일치", matchCount -> matchCount == 5, Money.of(1_500_000)),
    SIX_MATCH("6개 일치", matchCount -> matchCount == 6, Money.of(2_000_000_000));

    private final String description;
    private final Predicate<Integer> matchCondition;
    private final Money prize;

    private static final List<LottoPrize> EXCLUSIVE_MISS_LIST = EnumSet.allOf(LottoPrize.class)
                                                                       .stream()
                                                                       .filter(lottoPrize -> lottoPrize != MISS)
                                                                       .collect(Collectors.toList());

    LottoPrize(String description, Predicate<Integer> matchCondition, Money prize) {
        this.description = description;
        this.matchCondition = matchCondition;
        this.prize = prize;
    }

    public String description() {
        return description;
    }

    public Money prize() {
        return prize;
    }

    public static LottoPrize valueOf(int matchCount) {
        return Arrays.stream(values())
                     .filter(it -> it.matchCondition.test(matchCount))
                     .findFirst()
                     .orElse(MISS);
    }

    public static List<LottoPrize> exclusiveMiss() {
        return Collections.unmodifiableList(EXCLUSIVE_MISS_LIST);
    }
}
