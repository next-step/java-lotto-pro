package lotto.domain;

import java.util.Arrays;
import java.util.List;

public enum LottoRank {

    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000);

    private int countOfMatch;
    private int winningMoney;

    private LottoRank(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public static List<LottoRank> reverse() {
        return Arrays.asList(FOURTH, THIRD, SECOND, FIRST);
    }

    public static LottoRank valueOf(int countOfMatch) {
        return Arrays.stream(values())
                .filter(rank -> countOfMatch == rank.countOfMatch)
                .findFirst()
                .orElse(null);
    }
}