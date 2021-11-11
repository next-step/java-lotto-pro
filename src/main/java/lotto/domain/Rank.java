package lotto.domain;

import java.util.Arrays;

public enum Rank {

    FIRST_PLACE(6, 2_000_000_000, false),
    SECOND_PLACE(5, 1_500_000, false),
    BONUS_SECOND_PLACE(5, 30_000_000, true),
    THIRD_PLACE(4, 50_000, false),
    FOURTH_PLACE(3, 5_000, false),
    LOSER(0 ,0, false);

    private int winningNumberCount;
    private int prizeMoney;
    private boolean isBonus;

    Rank(int winningNumberCount, int prizeMoney, boolean isBonus) {
        this.winningNumberCount = winningNumberCount;
        this.prizeMoney = prizeMoney;
        this.isBonus = isBonus;
    }

    static Rank of(int winningNumberCount, boolean matchBonus) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.winningNumberCount == winningNumberCount &&
                        rank.isBonus == matchBonus)
                .findFirst()
                .orElse(LOSER);
    }

    public boolean isPrize() {
        return this != Rank.LOSER;
    }

    public long prizeMoneyCalculation(int winningCount) {
        return (long) this.prizeMoney * winningCount;
    }

}


