package lotto.domain;

import java.util.Arrays;
import java.util.List;

public enum WinningRank {
    FIRST(2_000_000_000, 6, false),
    SECOND(30_000_000, 5, true),
    THIRD(1_500_000, 5, false),
    FOURTH(50_000, 4, false),
    FIFTH(5_000, 3, false),
    NONE(0, 0, false);

    private static final List<WinningRank> PRINT_WINNING_RANKS = Arrays.asList(FIFTH, FOURTH, THIRD, SECOND, FIRST);

    public final Integer price;
    public final Integer matchCount;
    public final Boolean matchedBonus;

    WinningRank(Integer price, Integer matchCount, boolean matchedBonus) {
        this.price = price;
        this.matchCount = matchCount;
        this.matchedBonus = matchedBonus;
    }

    public static WinningRank of(int matchCount, boolean matchedBonus) {
        return Arrays.stream(WinningRank.values())
                .filter(r -> r.matchCount == matchCount && (!r.matchedBonus || matchedBonus))
                .findFirst()
                .orElse(NONE);
    }

    public static List<WinningRank> getPrintWinningRanks() {
        return PRINT_WINNING_RANKS;
    }
}
