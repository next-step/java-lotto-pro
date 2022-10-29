package step3.model;

import java.util.Arrays;

public enum Award {
    FIRST(6, 2_000_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private int countOfMatch;
    private int winningMoney;

    Award(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public int countOfMatch() {
        return countOfMatch;
    }

    public int winningMoney() {
        return winningMoney;
    }

    public static Award valueOf(int countOfMatch) {

        return Arrays.stream(Award.values())
            .filter(each -> each.countOfMatch() == countOfMatch)
            .findFirst()
            .orElse(MISS)
            ;
    }
}
