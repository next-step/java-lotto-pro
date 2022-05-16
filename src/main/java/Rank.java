import java.util.Arrays;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NONE(0, 0);

    private final static int PRIZE_LOWER_BOUND_COUNT = FIFTH.count;

    private final int count;
    private final long money;

    Rank(int count, long money) {
        this.count = count;
        this.money = money;
    }

    public static Rank valueOf(int containCount, boolean containBonusNumber) {
        if (LottoNumbers.SIZE < containCount)
            return NONE;

        if (PRIZE_LOWER_BOUND_COUNT > containCount)
            return NONE;

        if (SECOND.count == containCount) {
            return containBonusNumber ? SECOND : THIRD;
        }

        return Arrays.stream(new Rank[] { FIRST, FOURTH, FIFTH, NONE })
                .filter(it -> it.count == containCount)
                .findAny().orElse(NONE);
    }

    public boolean win() {
        return !NONE.equals(this);
    }

    public long money() {
        return this.money;
    }

    @Override
    public String toString() {
        if (this == SECOND)
            return count + "개 일치, 보너스 볼 일치(" + money + "원)";

        return count + "개 일치 (" + money + "원)";
    }
}
