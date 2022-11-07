package domain;

import java.util.Arrays;

public enum PrizeMoney {
    FIRST_PLACE(6, 200000000, false),
    SECOND_PLACE(5, 30000000, true),
    THIRD_PLACE(5, 1500000, false),
    FOURTH_PLACE(4, 50000, false),
    FIFTH_PLACE(3, 5000, false),
    OTHER_PLACE(0, 0, false);

    private final int collectCount;
    private final int prizeMoney;

    private final boolean matchBonus;

    PrizeMoney(int collectCount, int prizeMoney, boolean matchBonus) {
        this.collectCount = collectCount;
        this.prizeMoney = prizeMoney;
        this.matchBonus = matchBonus;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public int getCollectCount() {
        return collectCount;
    }

    public static PrizeMoney valueOf(int collectCount, boolean matchBonus) {
        return Arrays.stream(PrizeMoney.values())
                .filter(each -> each.collectCount == collectCount)
                .filter(each -> !each.equals(SECOND_PLACE) || matchBonus)
                .findFirst()
                .orElse(OTHER_PLACE);
    }

    public boolean isSecondPlace(PrizeMoney prizeMoney) {
        return SECOND_PLACE.equals(prizeMoney);
    }


}
