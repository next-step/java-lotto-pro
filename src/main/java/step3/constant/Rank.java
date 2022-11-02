package step3.constant;

import java.util.Arrays;

public enum Rank {
    FIRST(6, false, 2000000000),
    SECOND(5, true, 30000000),
    THIRD(5, false, 1500000),
    FOURTH(4, false, 50000),
    FIFTH(3, false, 5000),
    MISS(0, false, 0);

    private int countOfMatch;
    private boolean isBonus;
    private int winningMoney;

    private Rank(int countOfMatch, boolean isBonus, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.isBonus = isBonus;
        this.winningMoney = winningMoney;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public static Rank[] rankValues() {
        return values();
    }

    public static Rank valueOf(int countOfMatch, boolean matchBonus) {
        Rank[] ranks = values();
        if (matchBonus == SECOND.isBonus && countOfMatch == SECOND.getCountOfMatch()) {
            return Rank.SECOND;
        }
        return Arrays.stream(ranks)
                .filter(rank -> !rank.isBonus)
                .filter(rank -> rank.getCountOfMatch() == countOfMatch)
                .findAny()
                .orElse(Rank.MISS);
    }
}
