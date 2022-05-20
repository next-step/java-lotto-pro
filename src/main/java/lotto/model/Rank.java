package lotto.model;

import java.util.Arrays;
import java.util.Optional;

public enum Rank {
    FIFTH(3, 5000),
    FOURTH(4, 50000),
    THIRD(5, 1500000),
    SECOND(5, 30000000),
    FIRST(6, 2000000000);

    private final int sameCount;
    private final int winningMoney;

    Rank(int sameCount, int winningMoney) {
        this.sameCount = sameCount;
        this.winningMoney = winningMoney;
    }

    public int sameCount() {
        return sameCount;
    }

    public int winningMoney() {
        return winningMoney;
    }

    public static Optional<Rank> matchCountOf(Integer sameCount) {
        return Arrays.stream(values()).filter(rank -> rank.sameCount == sameCount).findFirst();
    }
}
