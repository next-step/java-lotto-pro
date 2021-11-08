package lotto.model;

import java.util.Arrays;

public enum LottoRank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private final int matchCount;
    private final int money;

    LottoRank(int matchCount, int money) {
        this.matchCount = matchCount;
        this.money = money;
    }

    public static LottoRank valueOf(int matchCount, boolean bonus) {
        if(matchCount == SECOND.matchCount) {
            return rankSecondAndThird(bonus);
        }
        return Arrays.stream(LottoRank.values())
                .filter(lottoRank -> lottoRank.matchCount == matchCount)
                .findAny()
                .orElse(LottoRank.MISS);
    }

    private static LottoRank rankSecondAndThird(boolean bonus) {
        if(bonus) {
            return SECOND;
        }
        return THIRD;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getMoney() {
        return money;
    }

    public long getTotal(int count) {
        return money * count;
    }
}
