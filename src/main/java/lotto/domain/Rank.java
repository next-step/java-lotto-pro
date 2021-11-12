package lotto.domain;

import java.util.Arrays;

public enum Rank {

    FIRST_PLACE(6, new PrizeMoney(2_000_000_000), false),
    SECOND_PLACE(5, new PrizeMoney(1_500_000), false),
    BONUS_SECOND_PLACE(5, new PrizeMoney(30_000_000), true),
    THIRD_PLACE(4, new PrizeMoney(50_000), false),
    FOURTH_PLACE(3, new PrizeMoney(5_000), false),
    LOSER(0, new PrizeMoney(0), false);

    private int winningNumberCount;
    private PrizeMoney prizeMoney;
    private boolean isBonus;

    Rank(int winningNumberCount, PrizeMoney prizeMoney, boolean isBonus) {
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

    public PrizeMoney getPrizeMoney() {
        return prizeMoney;
    }
}


