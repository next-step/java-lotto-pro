import java.util.Arrays;

public enum Prize {
    FIRST(6, 2000000000), SECOND(5, 1500000), THIRD(4, 50000),
    FOURTH(3, 5000), NONE(0, 0);

    private final static int PRIZE_LOWER_BOUND_COUNT = FOURTH.count;

    private final int count;
    private final long money;

    Prize(int count, long money) {
        this.count = count;
        this.money = money;
    }

    public static Prize find(int count) {
        if (PRIZE_LOWER_BOUND_COUNT > count)
            return NONE;

        return Arrays.stream(values())
                .filter(it -> it.count == count)
                .findAny()
                .orElseThrow(RuntimeException::new);
    }

    @Override
    public String toString() {
        return count + "개 일치 (" + money + "원)";
    }
}
