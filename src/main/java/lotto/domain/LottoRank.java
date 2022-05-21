package lotto.domain;

import java.util.Arrays;
import java.util.List;

public enum LottoRank {

    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000);

    private final int countOfMatch;
    private final int winningMoney;

    LottoRank(int countOfMatch, int winningMoney) {
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
        return Arrays.asList(FIFTH, FOURTH, THIRD, SECOND, FIRST);
    }

    public static LottoRank valueOf(int countOfMatch) {
        return Arrays.stream(values())
                .filter(rank -> countOfMatch == rank.countOfMatch)
                .findFirst()
                .orElse(null);
    }

    public static boolean isSecond(LottoRank rank) {
        return SECOND == rank;
    }
}