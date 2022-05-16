package lotto.constants;

import java.util.HashMap;
import java.util.Map;

public enum Matched {
    NOT_MATCHED(0, 0),
    ONE_MATCHED(1, 0),
    TWO_MATCHED(2, 0),
    THREE_MATCHED(3, 5_000),
    FOUR_MATCHED(4, 50_000),
    FIVE_MATCHED(5, 1_500_000),
    SIX_MATCHED(6, 2_000_000_000);

    private final int count;
    private final int reward;
    private static final Map<Integer, Matched> countMap = new HashMap<>();

    static {
        for (final Matched matched : Matched.values()) {
            countMap.put(matched.count, matched);
        }
    }

    Matched(final int count, final int reward) {
        this.count = count;
        this.reward = reward;
    }

    public int getCount() {
        return this.count;
    }

    public int getReward() {
        return this.reward;
    }

    public static Matched getByCount(final int count) {
        return countMap.get(count);
    }
}
