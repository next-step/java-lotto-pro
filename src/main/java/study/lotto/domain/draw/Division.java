package study.lotto.domain.draw;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public enum Division {
    DIVISION_FOUR(3, new BigDecimal(5_000)),
    DIVISION_THREE(4, new BigDecimal(50_000)),
    DIVISION_TWO(5, new BigDecimal(1_500_000)),
    DIVISION_ONE(6, new BigDecimal(2_000_000_000));

    private static final Map<Integer, Division> BY_MATCH_COUNT = new HashMap<>();

    static {
        Arrays.stream(values()).forEach(division -> BY_MATCH_COUNT.put(division.matchCount, division));
    }

    private final int matchCount;
    private final BigDecimal prize;

    Division(int matchCount, BigDecimal prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public static Division valueOfMatchCount(int matchCount) {
        return BY_MATCH_COUNT.get(matchCount);
    }

    public BigDecimal getPrize() {
        return prize;
    }
}
