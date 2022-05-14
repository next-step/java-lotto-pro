package lotto;

import java.util.Arrays;

public enum LottoRanking {
    FIRST(6, "6개 일치", Money.from(2000000000)),
    THIRD(5, "5개 일치", Money.from(1500000)),
    FORTH(4, "4개 일치", Money.from(50000)),
    FIFTH(3, "3개 일치", Money.from(5000)),
    MISS(0, "꽝", Money.from(0));

    public static final int MATCH_COUNT_MAX_NUM = 6;
    public static final int MATCH_COUNT_MIN_NUM = 0;
    private final int matchCount;
    private final String text;
    private final Money money;

    LottoRanking(int matchCount, String text, Money money) {
        this.matchCount = matchCount;
        this.text = text;
        this.money = money;
    }

    public static LottoRanking findLottoRankingByMatchCount(int matchCount) {
        validMatchCount(matchCount);
        return Arrays.stream(LottoRanking.values())
                .filter(ranking -> ranking.matchCount() == matchCount)
                .findFirst()
                .orElse(LottoRanking.MISS);
    }

    private static void validMatchCount(int matchCount) {
        if (isNotLottoMatchCountRange(matchCount)) {
            throw new IllegalArgumentException("로또번호 일치 갯수가 유효하지 않습니다.");
        }
    }

    private static boolean isNotLottoMatchCountRange(int matchCount) {
        return matchCount < MATCH_COUNT_MIN_NUM || matchCount > MATCH_COUNT_MAX_NUM;
    }

    private int matchCount() {
        return this.matchCount;
    }

    public Money money() {
        return this.money;
    }
}
