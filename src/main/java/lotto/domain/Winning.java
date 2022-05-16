package lotto.domain;

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
        if (match == 6) {
            return Winning.MATCH6;
        }
        if (match == 5) {
            return Winning.MATCH5;
        }
        if (match == 4) {
            return Winning.MATCH4;
        }
        if (match == 3) {
            return Winning.MATCH3;
        }
        return Winning.NAN;
    }

    public int getMoney() {
        return money;
    }

    @Override
    public String toString() {
        return String.format("%d개 일치 (%d원)", match, money);
    }
}
