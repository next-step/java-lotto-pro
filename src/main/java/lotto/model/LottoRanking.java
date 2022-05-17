package lotto.model;

import java.util.Arrays;

public enum LottoRanking {
    FIFTH(3, "3개 일치", Money.valueOf(5000), false),
    FORTH(4, "4개 일치", Money.valueOf(50000), false),
    THIRD(5, "5개 일치", Money.valueOf(1500000), false),
    SECOND(5, "5개 일치, 보너스 볼 일치", Money.valueOf(30000000), true),
    FIRST(6, "6개 일치", Money.valueOf(2000000000), false),
    MISS(0, "꽝", Money.valueOf(0), false);

    private static final int COUNT_OF_MATCH_MAX_NUM = 6;
    private static final int COUNT_OF_MATCH_MIN_NUM = 0;
    private final int countOfMatch;
    private final String text;
    private final Money money;
    private final Boolean isBonusMatched;

    LottoRanking(int countOfMatch, String text, Money money, boolean isBonusMatched) {
        this.countOfMatch = countOfMatch;
        this.text = text;
        this.money = money;
        this.isBonusMatched = isBonusMatched;
    }

    public static LottoRanking findLottoRankingByCountOfMatchAndBonusMatched(int countOfMatch, boolean isBonusMatched) {
        validateCountOfMatch(countOfMatch);
        return Arrays.stream(LottoRanking.values())
                .filter(ranking -> ranking.countOfMatch() == countOfMatch && ranking.isBonusMatched() == isBonusMatched)
                .findFirst()
                .orElse(LottoRanking.MISS);
    }

    public Money money() {
        return this.money;
    }

    public String text() {
        return this.text;
    }

    private static void validateCountOfMatch(int countOfMatch) {
        if (isNotLottoCountOfMatchRange(countOfMatch)) {
            throw new IllegalArgumentException("로또번호 일치 갯수가 유효하지 않습니다.");
        }
    }

    private static boolean isNotLottoCountOfMatchRange(int countOfMatch) {
        return countOfMatch < COUNT_OF_MATCH_MIN_NUM || countOfMatch > COUNT_OF_MATCH_MAX_NUM;
    }

    private int countOfMatch() {
        return this.countOfMatch;
    }

    private boolean isBonusMatched() {
        return this.isBonusMatched;
    }
}
