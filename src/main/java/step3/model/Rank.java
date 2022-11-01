package step3.model;

import java.util.Arrays;

public enum Rank {

    FIRST(new RankFunction((countOfMatch, isMatchBonus) -> countOfMatch == 6, 6), 2_000_000_000),
    SECOND(new RankFunction((countOfMatch, isMatchBonus) -> countOfMatch == 5 && isMatchBonus, 5), 30_000_000),
    THIRD(new RankFunction((countOfMatch, isMatchBonus) -> countOfMatch == 5 && !isMatchBonus, 5), 1_500_000),
    FOURTH(new RankFunction((countOfMatch, isMatchBonus) -> countOfMatch == 4, 4), 50_000),
    FIFTH(new RankFunction((countOfMatch, isMatchBonus) -> countOfMatch == 3, 3), 5_000),
    MISS(new RankFunction((countOfMatch, isMatchBonus) -> countOfMatch < 3, 0), 0);

    private final int winningPrice;
    private final RankFunction rankFunction;

    Rank(RankFunction rankFunction, int winningPrice) {
        this.rankFunction = rankFunction;
        this.winningPrice = winningPrice;
    }

    public static Rank valueOf(int matchCount, boolean hasBonus) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.rankFunction.isMatch(matchCount, hasBonus))
                .findFirst()
                .orElse(MISS);
    }

    public int getWinningPrice() {
        return winningPrice;
    }

    public int getMatchCount() {
        return rankFunction.getMatchCount();
    }

}
