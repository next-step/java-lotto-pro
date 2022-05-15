package lotto.constant;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public enum LottoRank {

    FOURTH(3, 5_000),
    THIRD(4, 50_000),
    SECOND(5, 1_500_000),
    SECOND_BONUS(5, 30_000_000),
    FIRST(6, 2_000_000_000),
    NONE(0, 0);

    private final int matchNumberCount;
    private final int winningAmount;
    private static final Map<Integer, LottoRank> matchCountRankMap = new HashMap<>();

    static {
        for (LottoRank lottoRank : EnumSet.of(FIRST,SECOND,THIRD,FOURTH,NONE)) {
            matchCountRankMap.put(lottoRank.matchNumberCount, lottoRank);
        }
    }

    LottoRank(int matchNumberCount, int winningAmount) {
        this.matchNumberCount = matchNumberCount;
        this.winningAmount = winningAmount;
    }

    public int getMatchNumberCount() {
        return matchNumberCount;
    }

    public int getWinningAmount() {
        return winningAmount;
    }

    public static LottoRank of(int matchNumberCount, boolean isBonusMatch) {
        LottoRank lottoRank = matchCountRankMap.getOrDefault(matchNumberCount, NONE);
        if(SECOND.equals(lottoRank) && isBonusMatch){
            return SECOND_BONUS;
        }
        return lottoRank;
    }

    public static Set<LottoRank> valuesExcludeNone() {
        return EnumSet.of(FIRST,SECOND_BONUS, SECOND, THIRD, FOURTH);
    }
}
