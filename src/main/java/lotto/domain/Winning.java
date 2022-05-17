package lotto.domain;

import java.util.Arrays;

public enum Winning {
    MATCH6(6, 2000000000),
    MATCH5(5, 1500000),
    MATCH4(4, 50000),
    MATCH3(3, 5000),
    NAN(0, 0);

    private final int match;
    private final int money;

    Winning(int match, int money) {
        this.match = match;
        this.money = money;
    }

    public static Winning from(int match) {
        return Arrays.stream(values())
                .filter(winning -> winning.match == match)
                .findFirst()
                .orElse(NAN);
    }

    public int getMoney() {
        return money;
    }

    @Override
    public String toString() {
        return String.format("%d개 일치 (%d원)", match, money);
    }
}
