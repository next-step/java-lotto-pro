package Lotto.enums;

import java.util.*;

public enum CompareEnum implements Comparator<CompareEnum> {
    First(6, 2_000_000_000, 1),
    Second(5, 30_000_000, 2),
    Third(5, 1_500_000, 3),
    Fourth(4, 50_000, 4),
    Fifth(3, 5_000, 6),
    Fail(0, 0, 6);

    private long hitCount;
    private int winningAmount;
    private int order;

    CompareEnum() { }

    CompareEnum(long hitCount, int winningAmount, int order) {
        this.hitCount = hitCount;
        this.winningAmount = winningAmount;
        this.order = order;
    }

    public int getWinningAmount() {
        return winningAmount;
    }

    public int getOrder() {
        return order;
    }

    public static Set<CompareEnum> valuesExcludeNone() {
        return EnumSet.of(First, Second, Third, Fourth, Fifth);
    }

    public static CompareEnum valueOf(long countOfMatch, boolean matchBonus) {
        Optional<CompareEnum> result =  valuesExcludeNone()
                                        .stream()
                                        .sorted()
                                        .filter(compareEnum -> compareEnum.hitCount == countOfMatch)
                                        .findFirst();

        if(!result.isPresent())
            return CompareEnum.Fail;

        if(result.get().hitCount == CompareEnum.Second.hitCount && !matchBonus) {
            return CompareEnum.Third;
        }

        return result.get();
    }

    @Override
    public int compare(CompareEnum rank1, CompareEnum rank2) {
        return rank1.order - rank2.order;
    }
}
