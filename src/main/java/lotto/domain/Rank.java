package lotto.domain;

import java.util.Arrays;
import java.util.Optional;

public enum Rank {
    FOURTH(3,5000),
    THIRD(4,50000),
    SECOND(5,1500000),
    FIRST(6,2000000000),
    FAIL(0,0)
    ;

    private final int matchCount;
    private final int winningAmount;

    Rank(int matchCount, int winningAmount) {

        this.matchCount = matchCount;
        this.winningAmount = winningAmount;
    }

    public int getMatchCount(){
        return matchCount;
    }

    public int getWinningAmount(){
        return winningAmount;
    }

    public boolean sameMatchCount(Integer c) {
        return this.getMatchCount() == c;
    }

    public String getWinningAmountString() {
        return String.format("%d원",this.getWinningAmount());
    }

    public static Rank findRank(int matchCount){
        Optional<Rank> rankOptional = Arrays.stream(Rank.values())
                .filter(rank -> rank.sameMatchCount(matchCount))
                .findFirst();
        return rankOptional.orElse(FAIL);
    }



}
