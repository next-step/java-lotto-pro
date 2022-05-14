package lotto.rank;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum LottoRank {

    NO_PRIZE(0, -1)
    , FOURTH_PLACE(5000, 3)
    , THIRD_PLACE(50000, 4)
    , SECOND_PLACE(1500000, 5)
    , FIRST_PLACE(2000000000, 6);

    public static final int MIN_MATCH_COUNT_FOR_PRIZE = 3;

    private final int matchNumberCount;
    private final long prize;

    LottoRank(long prize, int matchNumberCount) {
        this.prize = prize;
        this.matchNumberCount = matchNumberCount;
    }

    public static LottoRank getRank(int matchNumberCount) {
        if (isNoPrize(matchNumberCount)) {
            return NO_PRIZE;
        }
        Map<Integer, LottoRank> rankMap = makeRankMap();
        return rankMap.get(matchNumberCount);
    }

    private static boolean isNoPrize(int matchNumberCount) {
        return matchNumberCount < MIN_MATCH_COUNT_FOR_PRIZE;
    }

    private static Map<Integer, LottoRank> makeRankMap() {
        Map<Integer, LottoRank> map = new HashMap<>();
        for (LottoRank rank : EnumSet.allOf(LottoRank.class)) {
            map.put(rank.matchNumberCount, rank);
        }
        return map;
    }

    public int getMatchNumberCount() {
        return matchNumberCount;
    }

    public long calculatePrize(int count) {
        return this.prize * count;
    }
}
