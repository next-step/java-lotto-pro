package lotto.model;

import java.util.Arrays;

public enum LottoRank {
    NO_MATCHES(0, 0),
    THREE_MATCHES(3, 5000),
    FOUR_MATCHES(4, 50000),
    FIVE_MATCHES(5, 1500000),
    SIX_MATCHES(6, 2000000000);

    private final int matchCount;
    private final int money;

    LottoRank(int matchCount, int money) {
        this.matchCount = matchCount;
        this.money = money;
    }

    public static LottoRank valueOf(int matchCount) {
        return Arrays.stream(LottoRank.values())
                .filter(lottoRank -> lottoRank.matchCount == matchCount)
                .findAny()
                .orElse(LottoRank.NO_MATCHES);
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
