package step3;

import java.util.HashMap;
import java.util.Map;

public enum Rank {
    NONE(0, 0),
    FORTH(3, 5000),
    THIRD(4, 50000),
    SECOND(5, 1500000),
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
        if(matchCount < Rank.FORTH.count) {
            return Rank.NONE;
        }
        return rankByCount.get(matchCount);
    }
    
    public long getCount() {
        return count;
    }
    
    public long getPrize() {
        return prize;
    }
    
}
