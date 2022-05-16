package lotto.enums;

import java.util.Arrays;

public enum LottoRank {
    NONE(0, 0),
    FOURTH(3, 5_000),
    THIRD(4, 50_000),
    SECOND(5, 1_500_000),
    SECOND_BONUS(5, 30_000_000),
    FIRST(6, 2_000_000_000);

    private final int matchingCount;

    private final int prizeMoney;

    LottoRank(int matchingCount, int prizeMoney) {
        this.matchingCount = matchingCount;
        this.prizeMoney = prizeMoney;
    }

    public static LottoRank find(int matchingCount) {
        return find(matchingCount, false);
    }

    public static LottoRank find(int matchingCount, boolean matchBonus) {
        LottoRank lottoRank = Arrays.stream(values())
                .filter(val -> val.matchingCount == matchingCount)
                .findFirst()
                .orElse(NONE);

        if (SECOND == lottoRank && matchBonus) lottoRank = SECOND_BONUS;
        return lottoRank;
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }
}
