package camp.nextstep.edu.step3;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

public enum Hit {
    ZERO(0, 0L),
    ONE(1, 0L),
    TWO(2, 0L),
    THREE(3, 5_000L),
    FOUR(4, 50_000L),
    FIVE(5, 1_500_000L),
    FIVE_BONUS(5, 30_000_000L),
    ALL(6, 2_000_000_000L);

    private final int count;
    private final long prizeMoney;

    Hit(final int count, final long prizeMoney) {
        this.count = count;
        this.prizeMoney = prizeMoney;
    }

    public static Hit[] winningList() {
        return Arrays.stream(Hit.values())
                .filter((hit) -> hit.isWin(TWO))
                .toArray(Hit[]::new);
    }

    static Hit valueOf(final int hitCount, final boolean isHitBonus) {
        Optional<Hit> isResult = Arrays.stream(Hit.values())
                .filter((hit) -> hit.isSame(hitCount, isHitBonus))
                .findAny();
        if (isResult.isPresent()) {
            return isResult.get();
        }
        throw new IllegalArgumentException();
    }

    long winningAmount(final int perSheet) {
        return this.prizeMoney * perSheet;
    }

    public boolean isWin(final Hit destination) {
        return destination.isLow(this.count);
    }

    private boolean isLow(final int count) {
        return this.count < count;
    }

    private boolean isSame(final int hitCount, final boolean isBonus) {
        if (Objects.equals(this, Hit.FIVE) && isBonus) {
            return false;
        }
        return this.count == hitCount;
    }

    @Override
    public String toString() {
        if (this == FIVE_BONUS) {
            return String.format("%d개 일치, 보너스 볼 일치(%d원)", this.count, this.prizeMoney);
        }
        return String.format("%d개 일치 (%d원)", this.count, this.prizeMoney);
    }
}
