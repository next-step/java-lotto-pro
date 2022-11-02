package step3.enums;

import step3.domain.LottoMatcher;

import java.util.*;

public enum Rank {
    BASE(0, new LottoMatcher(0, false), 0),
    FIFTH(5, new LottoMatcher(3, false), 5000),
    FOURTH(4, new LottoMatcher(4, false), 50000),
    THIRD(3, new LottoMatcher(5, false), 1500000),
    SECOND(2, new LottoMatcher(5, true), 30000000),
    FIRST(1, new LottoMatcher(6, false), 2000000000);

    private static int MONEY = 1000;

    private final int rank;
    private final LottoMatcher lottoMatcher;
    private final int amount;

    Rank(int rank, LottoMatcher lottoMatcher, int amount) {
        this.rank = rank;
        this.lottoMatcher = lottoMatcher;
        this.amount = amount;
    }

    public LottoMatcher getLottoMatcher() {
        return lottoMatcher;
    }
    public int getAmount() {
        return amount;
    }

    public static Rank rank(int matchCount, boolean isBonusMatch) {
        if (SECOND.getLottoMatcher().isEqualsToMatchCount(matchCount) && isBonusMatch) {
            return SECOND;
        }
        return Arrays.stream(values())
                .filter(award -> award.getLottoMatcher().isEqualsToMatchCount(matchCount))
                .findAny()
                .orElse(Rank.BASE);
    }

    public static int calculateLottoCount(int money) {
        return money / MONEY;
    }

    public static double statistic(int money) {
        double sum = Arrays.stream(values())
                .mapToInt(r -> r.getLottoMatcher().lottoCount() * r.getAmount())
                .sum();
        return Math.floor(sum / money * 100) / 100;
    }

}
