package lotto.domain;

import java.util.Arrays;

public enum Winning {
    MATCH6(6, false, 2000000000),
    MATCH5_BONUS(5, true, 30000000),
    MATCH5(5, false, 1500000),
    MATCH4(4, false, 50000),
    MATCH3(3, false, 5000),
    NAN(0, false, 0);

    private static final int BONUS_MATCH_COUNT = 5;
    private final int match;
    private final boolean bonus;
    private final int money;

    Winning(int match, boolean bonus, int money) {
        this.match = match;
        this.bonus = bonus;
        this.money = money;
    }

    public static Winning from(int match, boolean bonus) {
        return Arrays.stream(values())
                .filter(winning -> winning.isMatch(match, bonus))
                .findFirst()
                .orElse(NAN);
    }

    private boolean isMatch(int match, boolean bonus) {
        if (isBonusMatchCount()) {
            return this.match == match && this.bonus == bonus;
        }
        return this.match == match;
    }

    private boolean isBonusMatchCount() {
        return this.match == BONUS_MATCH_COUNT;
    }

    public int getMoney() {
        return money;
    }

    @Override
    public String toString() {
        if (isBonusMatchCount() && bonus) {
            return String.format("%d개 일치, 보너스 볼 일치(%d원)", match, money);
        }
        return String.format("%d개 일치 (%d원)", match, money);
    }
}
