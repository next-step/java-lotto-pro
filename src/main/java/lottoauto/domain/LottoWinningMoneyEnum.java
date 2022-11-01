package lottoauto.domain;

import java.util.Arrays;

public enum LottoWinningMoneyEnum {
    FIRST(6, 2000000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000);

    private int matchedCount;
    private long winningMoney;

    LottoWinningMoneyEnum(int matchedCount, long winningMoney) {
        this.matchedCount = matchedCount;
        this.winningMoney = winningMoney;
    }

    public static long calculateWinningMoneyByContainCount(int containCount, int resultCount) {
        return Arrays.stream(values())
                .filter(value -> value.matchedCount == containCount)
                .findFirst()
                .orElseThrow(
                        () -> new IllegalStateException("로또 순위 정보가 조회되지 않았습니다.")
                ).winningMoney * resultCount;
    }

    public int getMatchedCount() {
        return matchedCount;
    }

    public long getWinningMoney() {
        return winningMoney;
    }
}
