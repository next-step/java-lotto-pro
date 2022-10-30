package step3_4.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000, false),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private int countOfMatch;
    private int winningMoney;
    private boolean matchBonus;

    private Rank(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
        this.matchBonus = false;
    }

    private Rank(int countOfMatch, int winningMoney, boolean matchBonus) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
        this.matchBonus = matchBonus;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public static Rank valueOf(int countOfMatch) {
        return valueOf(countOfMatch, false);
    }

    public static Rank valueOf(int countOfMatch, boolean bonusMatch) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.isMatch(countOfMatch, bonusMatch))
                .findFirst()
                .orElseGet(() -> Rank.MISS);
    }

    private boolean isMatch(int countOfMatch, boolean matchBonus) {
        return this.countOfMatch == countOfMatch
                && this.matchBonus == matchBonus;
    }
}
