package lotto.domain;

import java.util.Arrays;
import java.util.List;

public enum WinningRank {
    FIRST(2000000000, 6),
    SECOND(1500000, 5),
    THIRD(50000, 4),
    FOURTH(5000, 3),
    NONE(0, 0);

    public static final List<WinningRank> PRINT_WINNING_RANKS = Arrays.asList(FOURTH, THIRD, SECOND, FIRST);

    public final Integer price;
    public final Integer matchCount;

    WinningRank(Integer price, Integer matchCount) {
        this.price = price;
        this.matchCount = matchCount;
    }

    public static WinningRank of(int matchCount) {
        return Arrays.stream(WinningRank.values())
                .filter(r -> r.matchCount == matchCount)
                .findFirst()
                .orElse(NONE);
    }

    public static List<WinningRank> getPrintWinningRanks() {
        return PRINT_WINNING_RANKS;
    }
}
