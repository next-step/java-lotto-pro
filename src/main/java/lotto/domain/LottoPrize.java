package lotto.domain;

public enum LottoPrize {

    FIRST_PLACE("1등", 6, 2_000_000_000)
    , SECOND_PLACE("2등", 5, 1_500_000)
    , THIRD_PLACE("3등", 4, 50_000)
    , FOURTH_PLACE("4등", 3, 5_000);

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

    public static int getPrizeMoney(int matchCount) {
        if (matchCount == FIRST_PLACE.matchCount) {
            return FIRST_PLACE.prizeMoney;
        }
        if (matchCount == SECOND_PLACE.matchCount) {
            return SECOND_PLACE.prizeMoney;
        }
        if (matchCount == THIRD_PLACE.matchCount) {
            return THIRD_PLACE.prizeMoney;
        }
        if (matchCount == FOURTH_PLACE.matchCount) {
            return FOURTH_PLACE.prizeMoney;
        }
        return 0;
    }
}
