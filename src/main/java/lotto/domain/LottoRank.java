package lotto.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public enum LottoRank {

    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    NONE(0, false, 0);

    private final int countMatch;

    private final boolean matchBonus;

    private final int winningMoney;

    LottoRank(int countMatch, boolean matchBonus, int winningMoney) {
        this.countMatch = countMatch;
        this.matchBonus = matchBonus;
        this.winningMoney = winningMoney;
    }

    public int getCountMatch() {
        return countMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public boolean isMatchBonus() {
        return matchBonus;
    }

    public static LottoRank valueOf(int countMatch, boolean matchBonus) {
        return Arrays.stream(values())
            .filter(lottoLank -> countMatch == lottoLank.countMatch)
            .filter(lottoLank -> matchBonus == lottoLank.matchBonus)
            .findFirst()
            .orElse(NONE);
    }

    public static List<LottoRank> reverse() {
        return Arrays.asList(FIFTH, FOURTH, THIRD, SECOND, FIRST);
    }

    public static boolean isNone(LottoRank lottoRank) {
        return Objects.equals(lottoRank, NONE);
    }
}
