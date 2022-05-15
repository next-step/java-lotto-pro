package lotto.enums;

import java.util.Arrays;
import java.util.List;

public enum LottoRank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000),
    MISS(0, 0);

    private int countOfMatch;
    private int winningMoney;

    LottoRank(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public static LottoRank valueOf(int countOfMatch) {
        return Arrays.stream(LottoRank.values()).
                filter(lr -> lr.getCountOfMatch() == countOfMatch).
                findAny().
                orElse(MISS);
    }

    public static List<LottoRank> getPrizedRanks() {
        return Arrays.asList(FIRST, SECOND, THIRD, FOURTH);
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }
}
