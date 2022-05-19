package lotto.model;

import java.util.function.BiPredicate;

public enum LottoRanking {
    FIFTH("3개 일치", Money.valueOf(5000), (countOfMatch, isBonusMatched) -> countOfMatch == 3),
    FORTH("4개 일치", Money.valueOf(50000), (countOfMatch, isBonusMatched) -> countOfMatch == 4),
    THIRD("5개 일치", Money.valueOf(1500000),
            (countOfMatch, isBonusMatched) -> countOfMatch == 5 && !isBonusMatched),
    SECOND("5개 일치, 보너스 볼 일치", Money.valueOf(30000000),
            (countOfMatch, isBonusMatched) -> countOfMatch == 5 && isBonusMatched),
    FIRST("6개 일치", Money.valueOf(2000000000), (countOfMatch, isBonusMatched) -> countOfMatch == 6),
    MISS("꽝", Money.valueOf(0), (countOfMatch, isBonusMatched) -> countOfMatch == 0);

    public static final int COUNT_OF_MATCH_MAX_NUM = 6;
    public static final int COUNT_OF_MATCH_MIN_NUM = 0;
    private final String text;
    private final Money money;
    private final BiPredicate<Integer, Boolean> predicateWithCountOfMatchAndIsBonusMatched;

    LottoRanking(String text, Money money, BiPredicate<Integer, Boolean> predicateWithCountOfMatchAndIsBonusMatched) {
        this.text = text;
        this.money = money;
        this.predicateWithCountOfMatchAndIsBonusMatched = predicateWithCountOfMatchAndIsBonusMatched;
    }

    public BiPredicate<Integer, Boolean> predicateWithCountOfMatchAndIsBonusMatched() {
        return predicateWithCountOfMatchAndIsBonusMatched;
    }

    public Money money() {
        return this.money;
    }

    public String text() {
        return this.text;
    }
}
