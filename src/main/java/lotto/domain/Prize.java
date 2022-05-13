package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public enum Prize {
    NO_MATCHES(0, 0),
    THREE_MATCHES(3, 5000),
    FOUR_MATCHES(4, 50000),
    FIVE_MATCHES(5, 1500000),
    SIX_MATCHES(6, 2000000000),
    ;

    private static final Map<Integer, Prize> prizeByMatchCount = new HashMap<>();

    static {
        for (Prize prize : values()){
            prizeByMatchCount.put(prize.matchCount, prize);
        }
    }

    private final int matchCount;
    private final int prize;

    Prize(final int matchCount, final int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public static Prize findPrizeByMatchCount(final int matchCount) {
        return prizeByMatchCount.get(matchCount);
    }

    public int getPrize() {
        return prize;
    }

    public String resultMessage(final int matches) {
        return String.format("%d개 일치 (%d원)- %d", matchCount, prize, matches);
    }
}
