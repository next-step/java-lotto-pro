package step3.domain;

import java.util.HashMap;
import java.util.Map;

public enum Rank {
    NONE(0, 0),
    FIFTH(3, 5000),
    FORTH(4, 50000),
    THIRD(5, 1500000),
    //SECOND(5, 30000000),
    FIRST(6, 2000000000);
    
    private final int count;
    private final long prize;
    Rank(int count, int prize) {
        this.count = count;
        this.prize = prize;
    }
    
    private static final Map<Integer, Rank> rankByCount = new HashMap<>();
    static {
        for (Rank rank : values()) {
            rankByCount.put(rank.count, rank);
        }
    }
    
    public static Rank getRank(int matchCount) {
        if(matchCount < Rank.FIFTH.count) {
            return Rank.NONE;
        }
        return rankByCount.get(matchCount);
    }
    
    public static long getPrize(int matchCount) {
       return getRank(matchCount).getPrize();
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
}
