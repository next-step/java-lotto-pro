package lotto.domain;

import java.util.Arrays;
import java.util.Optional;

public enum Rank {
    FOURTH(3, 5_000),
    THIRD(4, 50_000),
    SECOND(5, 1_500_000),
    SECOND_WITH_BONUS(5, 30_000_000),
    FIRST(6, 2_000_000_000),
    FAIL(0, 0);

    private final int matchCount;
    private final int winningAmount;

    Rank(int matchCount, int winningAmount) {

        this.matchCount = matchCount;
        this.winningAmount = winningAmount;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getWinningAmount() {
        return winningAmount;
    }

    public boolean sameMatchCount(Integer c) {
        return this.getMatchCount() == c;
    }

    public String getWinningAmountString() {
        return String.format("%d원", this.getWinningAmount());
    }

    public static Rank findRank(int matchCount, boolean hasBonusNumber) {
        Optional<Rank> rankOptional = Arrays.stream(Rank.values())
                .filter(rank -> rank.sameMatchCount(matchCount))
                .findFirst();

        if (!rankOptional.isPresent()) {
            return FAIL;
        }
        if (matchCount == 5 && hasBonusNumber) {
            return SECOND_WITH_BONUS;
        }
        return rankOptional.get();
    }
}
