package step3.domain;

import java.util.Arrays;

public enum Rank {
    NONE(0, 0),
    FIFTH(3, 5000),
    FORTH(4, 50000),
    THIRD(5, 1500000),
    SECOND(5, 30000000),
    FIRST(6, 2000000000);
    
    private final int count;
    private final long prize;
    Rank(int count, int prize) {
        this.count = count;
        this.prize = prize;
    }

    public static Rank valueOf(int matchCount, boolean isMatchBonusNumber) {
        if(isSecond(matchCount, isMatchBonusNumber)){
            return Rank.SECOND;
        }
        return Arrays.stream(values())
                .filter(rank -> rank.count == matchCount && rank != Rank.SECOND )
                .findAny()
                .orElse(Rank.NONE);
    }
    
    public long getCount() {
        return count;
    }
    
    public long getPrize() {
        return prize;
    }
    
    public boolean isNone() {
        return this.count < Rank.FIFTH.count;
    }
    
    private static boolean isSecond(int matchCount, boolean isMatchBonusNumber) {
        return Rank.SECOND.count == matchCount && isMatchBonusNumber;
    }
}
