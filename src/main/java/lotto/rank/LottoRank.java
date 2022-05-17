package lotto.rank;

import java.util.stream.Stream;

public enum LottoRank {

    NO_PRIZE(0, -1)
    , FIFTH_PLACE(5000, 3)
    , FOURTH_PLACE(50000, 4)
    , THIRD_PLACE(1500000, 5)
    , SECOND_PLACE(30000000, 5)
    , FIRST_PLACE(2000000000, 6);

    public static final int MIN_MATCH_COUNT_FOR_PRIZE = 3;

    private final int matchNumberCount;
    private final long prize;

    LottoRank(long prize, int matchNumberCount) {
        this.prize = prize;
        this.matchNumberCount = matchNumberCount;
    }

    public static LottoRank getRank(int matchNumberCount, boolean containsBonusNumber) {
        if (isNoPrize(matchNumberCount)) {
            return NO_PRIZE;
        }
        if(isSecondPlace(matchNumberCount,containsBonusNumber)){
            return SECOND_PLACE;
        }
        return findRankByMatchNumberCount(matchNumberCount);
    }

    private static boolean isNoPrize(int matchNumberCount) {
        return matchNumberCount < MIN_MATCH_COUNT_FOR_PRIZE;
    }

    private static boolean isSecondPlace(int matchNumberCount, boolean containsBonusNumber){
        return matchNumberCount == SECOND_PLACE.matchNumberCount && containsBonusNumber;
    }

    private static LottoRank findRankByMatchNumberCount(int matchNumberCount){
        return Stream.of(LottoRank.values())
                .filter(rank->rank.matchNumberCount == matchNumberCount)
                .findFirst().orElse(NO_PRIZE);
    }

    public int getMatchNumberCount() {
        return matchNumberCount;
    }

    public long getPrize() {
        return prize;
    }

    public long calculatePrize(int count) {
        return this.prize * count;
    }
}
