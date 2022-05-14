package camp.nextstep.edu.step3;

import java.util.Arrays;

public enum Hit {
    ZERO(0, 0),
    ONE(1, 0),
    TWO(2, 0),
    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    ALL(6, 2_000_000_000);

    private final int count;
    private final int prizeMoney;

    Hit(int count, int prizeMoney) {
        this.count = count;
        this.prizeMoney = prizeMoney;
    }

    static Hit valueOf(final int hitCount) {
        return Hit.values()[hitCount];
    }

    public static Hit[] winningList() {
        return Arrays.stream(Hit.values())
                .filter(Hit.TWO::isLow)
                .toArray(Hit[]::new);
    }

    public boolean isLow(final Hit target) {
        return target.isHigh(this.count);
    }

    int cost(final int count) {
        return this.prizeMoney * count;
    }

    private boolean isHigh(final int destinationCount) {
        return this.count > destinationCount;
    }

    @Override
    public String toString() {
        return String.format("%d개 일치 (%d원)", this.count, this.prizeMoney);
    }
}
