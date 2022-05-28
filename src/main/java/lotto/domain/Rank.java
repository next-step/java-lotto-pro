package lotto.domain;

import java.util.Arrays;
import java.util.Optional;

public enum Rank {
    FIRST(6, 2_000_000_000, false),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000, false),
    FOURTH(4, 50_000, false),
    FIFTH(3, 5_000, false);

    private final int countOfMatch;
    private final int winningMoney;
    private final boolean bonusMatch;

    Rank(int countOfMatch, int winningMoney, boolean bonusMatch) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
        this.bonusMatch = bonusMatch;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public static Rank matchedRank(int countOfMatch, boolean bonusMatch) {
        Rank resultRank = null;

        Optional<Rank> matchedCountAndBonus = Arrays.stream(values())
                .filter(rank -> countOfMatch == rank.getCountOfMatch())
                .filter(rank -> bonusMatch == rank.bonusMatch || !rank.bonusMatch)
                .findFirst();

        if (matchedCountAndBonus.isPresent()) {
            resultRank = matchedCountAndBonus.get();
        }

        return resultRank;
    }
}