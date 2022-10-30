package lotto.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public enum LottoRank {

    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000),
    NONE(0, 0);

    private final int countMatch;
    private final int winningMoney;

    LottoRank(int countMatch, int winningMoney) {
        this.countMatch = countMatch;
        this.winningMoney = winningMoney;
    }

    public int getCountMatch() {
        return countMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public static LottoRank valueOf(int countMatch) {
        return Arrays.stream(values())
            .filter(lottoLank -> countMatch == lottoLank.countMatch)
            .findFirst()
            .orElse(NONE);
    }

    public static List<LottoRank> reverse() {
        return Arrays.asList(FOURTH, THIRD, SECOND, FIRST);
    }

    public static boolean isNone(LottoRank lottoRank) {
        return Objects.equals(lottoRank, NONE);
    }
}
