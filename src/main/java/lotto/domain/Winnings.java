package lotto.domain;

import java.util.Arrays;

public enum Winnings {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FORTH(4, false, 50_000),
    FIFTH(3, false,5_000),
    MISS(0, false,0);

    private final int correspondCount;
    private final boolean isBonus;
    private final long amount;

    Winnings(final int correspondCount, final boolean isBonus, final long amount) {
        this.correspondCount = correspondCount;
        this.isBonus = isBonus;
        this.amount = amount;
    }

    public long getAmount() {
        return this.amount;
    }

    private boolean isMatchExceptSecond(int correspondCount) {
        return this.correspondCount == correspondCount && !this.isBonus;
    }

    public boolean isSecond() {
        return this == SECOND;
    }

    public boolean isWin() {
        return this != MISS;
    }

    public static Winnings find(int correspondCount, boolean isBonus) {
        if(correspondCount == SECOND.correspondCount && isBonus) {
            return SECOND;
        }

        return Arrays.stream(values())
                .filter(w -> w.isMatchExceptSecond(correspondCount))
                .findFirst()
                .orElse(MISS);

    }

    @Override
    public String toString() {
        return String.format("%d개 일치(%d원)", this.correspondCount, this.amount);
    }

}
