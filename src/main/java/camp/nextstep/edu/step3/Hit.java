package camp.nextstep.edu.step3;

import java.util.Arrays;

public enum Hit {
    ZERO(0, 0L),
    ONE(1, 0L),
    TWO(2, 0L),
    THREE(3, 5000L),
    FOUR(4, 50000L),
    FIVE(5, 1500000L),
    ALL(6, 2_000_000_000L);

    private final int count;
    private final long prizeMoney;

    Hit(final int count, final long prizeMoney) {
        this.count = count;
        this.prizeMoney = prizeMoney;
    }

    public static Hit[] winningList() {
        return Arrays.stream(Hit.values())
                .filter((hit) -> hit.isHigh(TWO))
                .toArray(Hit[]::new);
    }

    static Hit valueOf(final int hitCount) {
        return Hit.values()[hitCount];
    }

    long winningAmount(final int perSheet) {
        return this.prizeMoney * perSheet;
    }

    public boolean isHigh(final Hit destination) {
        return destination.isLow(this.count);
    }

    private boolean isLow(final int count) {
        return this.count < count;
    }

    @Override
    public String toString() {
        return String.format("%d개 일치 (%d원)", this.count, this.prizeMoney);
    }
}
