package step3.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Ranking {
    NONE(0, 0, false),
    FIFTH(3, 5_000, false),
    FOURTH(4, 50_000, false),
    THIRD(5, 1_500_000, false),
    SECOND(5, 30_000_000, true),
    FIRST(6, 2_000_000_000, false);

    private final int hitCount;
    private final int winningMoney;
    private final boolean matchedBonusNumber;

    Ranking(int hitCount, int winningMoney, boolean matchedBonusNumber) {
        this.hitCount = hitCount;
        this.winningMoney = winningMoney;
        this.matchedBonusNumber = matchedBonusNumber;
    }

    public static Ranking findRanking(int hitCount, boolean matchedBonusNumber) {
        return Arrays.stream(values())
                .filter(ranking -> ranking.hitCount == hitCount)
                .filter(ranking -> ranking.matchedBonusNumber == matchedBonusNumber)
                .findFirst()
                .orElse(Ranking.NONE);
    }

    public int getHitCount() {
        return hitCount;
    }

    public long getWinningMoney() {
        return winningMoney;
    }

    public static List<Ranking> winners() {
        return Arrays.stream(Ranking.values())
                .filter(ranking -> ranking.getWinningMoney() > Ranking.NONE.getWinningMoney())
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "Ranking{" +
                "hitCount=" + hitCount +
                ", winningMoney=" + winningMoney +
                '}';
    }
}
