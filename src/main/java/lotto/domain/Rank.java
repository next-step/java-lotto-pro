package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6, new Money(2_000_000_000L)),
    SECOND(5, new Money(1_500_000L)),
    THIRD(4, new Money(50_000L)),
    FOURTH(3, new Money(5_000L));

    private final int matchCount;
    private final Money money;

    Rank(int matchCount, Money money) {
        this.matchCount = matchCount;
        this.money = money;
    }

    public static boolean isBiggerThanMinimum(int count) {
        return count >= FOURTH.matchCount;
    }

    public static Rank get(int matchCount) {
        return Arrays.stream(Rank.values())
                .filter(s -> s.getMatchCount() == matchCount)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("일치하는 랭크가 없습니다."));
    }

    public Money getMoney() {
        return money;
    }

    public Long getMoneyValue() {
        return money.value();
    }

    public int getMatchCount() {
        return matchCount;
    }
}
