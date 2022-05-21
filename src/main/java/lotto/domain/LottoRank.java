package lotto.domain;

import java.util.Arrays;
import java.util.List;

public enum LottoRank {

    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000);

    private final int countOfMatch;
    private final int winningMoney;
    private final boolean matchBonus;

    LottoRank(int countOfMatch, boolean matchBonus, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.matchBonus = matchBonus;
        this.winningMoney = winningMoney;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public boolean isMatchBonus() {
        return matchBonus;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public static List<LottoRank> reverse() {
        return Arrays.asList(FIFTH, FOURTH, THIRD, SECOND, FIRST);
    }
    
    public static LottoRank valueOf(int countOfMatch, boolean matchBonus) {
        return Arrays.stream(values())
                .filter(rank -> countOfMatch == rank.countOfMatch)
                .filter(rank -> rank.matchBonus == matchBonus)
                .findFirst()
                .orElse(null);
    }

    public static boolean isSecond(LottoRank rank) {
        return SECOND == rank;
    }
}