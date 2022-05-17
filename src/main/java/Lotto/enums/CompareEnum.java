package Lotto.enums;

import java.util.Comparator;
import java.util.EnumSet;
import java.util.Set;

public enum CompareEnum implements Comparator<CompareEnum> {
    First(6, 2_000_000_000, 1),
    Second(5, 1_500_000, 2),
    Third(4, 50_000, 3),
    Fourth(3, 5_000, 4),
    Fail(0, 0, 5);

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

    public static CompareEnum of(long hitCount) {
        if(hitCount == 6)
            return CompareEnum.First;

        if(hitCount == 5)
            return CompareEnum.Second;

        if(hitCount == 4)
            return CompareEnum.Third;

        if(hitCount == 3)
            return CompareEnum.Fourth;

        return CompareEnum.Fail;
    }

    public static Set<CompareEnum> valuesExcludeNone() {
        return EnumSet.of(First, Second, Third, Fourth);
    }

    @Override
    public int compare(CompareEnum rank1, CompareEnum rank2) {
        return rank1.order - rank2.order;
    }
}
