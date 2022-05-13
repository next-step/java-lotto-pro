package lotto.domain;

import java.util.Arrays;

public enum LottoRank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000),
    FAIL(0, 0);

    private final int matchCount;
    private final int money;

    LottoRank(int matchCount, int money) {
        this.matchCount = matchCount;
        this.money = money;
    }

    public int rewordMoney() {
        return this.money;
    }


    public static LottoRank reword(int matchCount) {
        return Arrays.stream(LottoRank.values())
                .filter((lottoRank -> sameMatchCount(matchCount, lottoRank)))
                .findFirst()
                .orElse(LottoRank.FAIL);
    }

    private static boolean sameMatchCount(int matchCount, LottoRank lottoRank) {
        return lottoRank.matchCount == matchCount;
    }


}
