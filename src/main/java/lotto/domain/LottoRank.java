package lotto.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum LottoRank {

    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000);

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
            .orElse(null);
    }

    public static List<LottoRank> reverse() {
        return Arrays.asList(FOURTH, THIRD, SECOND, FIRST);
    }

    public static Map<LottoRank, Integer> generateRankInfo() {
        Map<LottoRank, Integer> rankInfo = new HashMap<>();

        for (LottoRank lottoRank: LottoRank.reverse()) {
            rankInfo.put(lottoRank, 0);
        }

        return rankInfo;
    }
}
