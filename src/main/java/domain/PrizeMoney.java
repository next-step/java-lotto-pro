package domain;

import java.util.Arrays;

public enum PrizeMoney {
    FIRST_PLACE(6, 2000000000),
    SECOND_PLACE(5, 1500000),
    THIRD_PLACE(4, 50000),
    FOURTH_PLACE(3, 5000),
    OTHER_PLACE(0, 0);

    private final int collectCount;
    private final int prizeMoney;

    PrizeMoney(int collectCount, int prizeMoney) {
        this.collectCount = collectCount;
        this.prizeMoney = prizeMoney;
    }

    public int collectCount() {
        return collectCount;
    }

    public int prizeMoney() {
        return prizeMoney;
    }

    public static PrizeMoney valueOf(int collectCount) {
        return Arrays.stream(PrizeMoney.values())
                .filter(each -> each.collectCount == collectCount)
                .findFirst()
                .orElse(OTHER_PLACE);
    }

}
