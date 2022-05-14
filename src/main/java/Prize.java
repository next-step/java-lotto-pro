public enum Prize {
    FIRST(6, 2000000000), SECOND(5, 1500000), THIRD(4, 50000),
    FOURTH(3, 5000), NONE(0, 0);

    private final static int PRIZE_LOWER_BOUND_COUNT = FOURTH.count;

    private int count;
    private long money;

    Prize(int count, long money) {
        this.count = count;
        this.money = money;
    }

    public static Prize find(int count) {
        if (PRIZE_LOWER_BOUND_COUNT > count)
            return NONE;

        for (Prize prize : values()) {
            if (prize.count == count)
                return prize;
        }

        throw new RuntimeException();
    }

    @Override
    public String toString() {
        return count + "개 일치 (" + money + "원)";
    }
}
