package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6, Money.from(2_000_000_000), "6개 일치 (2,000,000,000원)"),
    SECOND(5, Money.from(30_000_000), "5개 일치, 보너스 볼 일치(30,000,000원)"),
    THIRD(5, Money.from(1_500_000), "5개 일치 (1,500,000원)"),
    FOURTH(4, Money.from(50_000), "4개 일치 (50,000원)"),
    FIFTH(3, Money.from(5_000), "3개 일치 (5,000원)"),
    NONE(0, Money.from(0), "꽝"),
    ;

    private final int matchCount;
    private final Money money;
    private final String message;

    Rank(int matchCount, Money money, String message) {
        this.matchCount = matchCount;
        this.money = money;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public static Rank matchResult(int matchCount, boolean isContainsBonusNumber) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.isEqualMatchCount(matchCount))
                .filter(rank -> !rank.equals(SECOND) || isContainsBonusNumber)
                .findAny()
                .orElse(Rank.NONE);
    }

    public boolean isEqualMatchCount(int matchCount) {
        return this.matchCount == matchCount;
    }

    public Money getWinningReward(int count) {
        return this.money.multiply(count);
    }
}
