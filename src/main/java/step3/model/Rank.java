package step3.model;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2_000_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private int matchCount;
    private int winningPrice;
    Rank(int matchCount,int winningPrice){
        this.matchCount = matchCount;
        this.winningPrice = winningPrice;
    }

    public static Rank getRankFromMatchCount(int matchCount){
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.matchCount == matchCount)
                .findFirst()
                .orElse(MISS);
    }

    public int getMatchCount(){
        return matchCount;
    }

    public int getWinningPrice() {
        return winningPrice;
    }
}
