package lotto.model;

import java.util.Arrays;

public enum LottoRank {
    FIRST(6, 2_000_000_000, false),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000, false),
    FOURTH(4, 50_000, false),
    FIFTH(3, 5_000, false),
    MISS(0, 0, false);

    private final int matchCount;
    private final int money;
    private final boolean bonus;

    LottoRank(int matchCount, int money, boolean bonus) {
        this.matchCount = matchCount;
        this.money = money;
        this.bonus = bonus;
    }

    public static LottoRank valueOf(int matchCount, boolean bonus) {
        return Arrays.stream(LottoRank.values())
                .filter(lottoRank -> lottoRank.matchCount == matchCount && lottoRank.bonus == bonus)
                .findAny()
                .orElse(LottoRank.MISS);
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
