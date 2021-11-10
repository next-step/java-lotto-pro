package lotto.domain;

import java.util.Arrays;

public enum LottoPrize {

    FIRST_PLACE("1등", 6, 2_000_000_000)
    , SECOND_PLACE("2등", 5, 30_000_000)
    , THIRD_PLACE("3등", 5, 1_500_000)
    , FOURTH_PLACE("4등", 4, 50_000)
    , FIFTH_PLACE("5등", 3, 5_000)
    , MISS("낙첨", 0, 0);

    private final String name;
    private final int matchCount;
    private final int prizeMoney;

    LottoPrize(String name, int matchCount, int prizeMoney) {
        this.name = name;
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
    }

    public String getName() {
        return name;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public static LottoPrize valueOf(int matchCount, boolean matchBonus) {
        if (matchCount == SECOND_PLACE.matchCount && matchBonus) {
            return SECOND_PLACE;
        }
        return Arrays.stream(values())
                .filter(LottoPrize::isNotSecondPlace)
                .filter(lottoPrize -> lottoPrize.isEqual(matchCount))
                .findFirst()
                .orElse(MISS);
    }

    private boolean isSecondPlace() {
        return this == SECOND_PLACE;
    }

    private boolean isNotSecondPlace() {
        return !isSecondPlace();
    }

    private boolean isEqual(int matchCount) {
        return this.matchCount == matchCount;
    }
}
