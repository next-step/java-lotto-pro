package step3.domain;

import java.util.HashMap;
import java.util.Map;

public class Reward {

    public static final Map<Integer, Long> criteria;
    private final int matchCount;
    private final long money;

    static {
        criteria = new HashMap<Integer, Long>() {
            {
                put(3, 5000L);
                put(4, 50000L);
                put(5, 1500000L);
                put(6, 2000000000L);
            }
        };
    }

    private Reward() {
        throw new RuntimeException("Cannot use default constructor.");
    }

    private Reward(Lotto lotto, Numbers winningNumber) {
        int matchCount = lotto.getMatchCount(winningNumber);
        if (!criteria.containsKey(matchCount)) {
            throw new RuntimeException("Non-winning numbers.");
        }
        this.matchCount = matchCount;
        this.money = criteria.get(matchCount);
    }

    public static Reward generate(Lotto lotto, Numbers winningNumber) {
        return new Reward(lotto, winningNumber);
    }
}
