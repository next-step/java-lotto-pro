package step3.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Ranking {
    NONE(0, 0),
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    //SECOND
    FIRST(6, 2_000_000_000);

    private final int hitCount;
    private final int winningMoney;

    Ranking(int hitCount, int winningMoney) {
        this.hitCount = hitCount;
        this.winningMoney = winningMoney;
    }

    public static Ranking findRanking(int hitCount) {
        return Arrays.stream(values())
                .filter(ranking -> ranking.hitCount == hitCount)
                .findFirst()
                .orElse(Ranking.NONE);
    }

    public double getWinningMoney() {
        return winningMoney;
    }

    public static List<Ranking> winners() {
        return Arrays.stream(Ranking.values())
                .filter(ranking -> ranking.getWinningMoney() > 0)
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return String.format("%d개 일치 (%d원)", hitCount, winningMoney);
    }
}
