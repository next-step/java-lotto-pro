package lottoauto.util;

import java.util.Arrays;

public enum Rank {
    FIRST(1,6, 2_000_000_000),
    SECOND(2,5, 30_000_000),
    THIRD(3,5, 1_500_000),
    FOURTH(4,4, 50_000),
    FIFTH(5,3, 5_000),
    MISS(0,0, 0);

    private int countOfMatch;
    private int winningMoney;
    private int lottoRank;

    private Rank(int countOfMatch, int winningMoney, int lottoRank) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
        this.lottoRank = lottoRank;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public int getLottoRank() {
        return lottoRank;
    }

    public static Rank valueOf(int countOfMatch, boolean matchBonus) {
        if (countOfMatch == THIRD.getCountOfMatch() && matchBonus) {
            return SECOND;
        }
        return Arrays.stream(values()).filter(rank -> rank.getCountOfMatch() == countOfMatch).findFirst().orElse(MISS);
    }
}


