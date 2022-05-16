package lotto.model;

import java.util.Arrays;

public enum LottoRanking {
    FIFTH(3, "3개 일치", Money.valueOf(5000)),
    FORTH(4, "4개 일치", Money.valueOf(50000)),
    THIRD(5, "5개 일치", Money.valueOf(1500000)),
    FIRST(6, "6개 일치", Money.valueOf(2000000000)),
    MISS(0, "꽝", Money.valueOf(0));

    private static final int COUNT_OF_MATCH_MAX_NUM = 6;
    private static final int COUNT_OF_MATCH_MIN_NUM = 0;
    private final int countOfMatch;
    private final String text;
    private final Money money;

    LottoRanking(int countOfMatch, String text, Money money) {
        this.countOfMatch = countOfMatch;
        this.text = text;
        this.money = money;
    }

    public static LottoRanking findLottoRankingByCountOfMatch(int countOfMatch) {
        validateCountOfMatch(countOfMatch);
        return Arrays.stream(LottoRanking.values())
                .filter(ranking -> ranking.countOfMatch() == countOfMatch)
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
}
