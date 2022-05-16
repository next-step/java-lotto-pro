package lotto.enums;

import java.util.Arrays;
import java.util.List;

public enum LottoRank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private int countOfMatch;
    private int winningMoney;

    LottoRank(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public static LottoRank valueOf(int countOfMatch, boolean matchBonus) {
        LottoRank rank = Arrays.stream(LottoRank.values()).
                filter(lr -> lr.getCountOfMatch() == countOfMatch).
                findAny().
                orElse(MISS);

        if (rank == SECOND && !matchBonus) {
            return THIRD;
        }
        return rank;
    }

    public static List<LottoRank> getPrizedRanks() {
        return Arrays.asList(FIRST, SECOND, THIRD, FOURTH, FIFTH);
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }
}
