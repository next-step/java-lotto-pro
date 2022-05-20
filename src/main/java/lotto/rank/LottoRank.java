package lotto.rank;

import java.util.stream.Stream;

public enum LottoRank {

    NO_PRIZE(0, -1){
        @Override
        protected boolean matchRank(int matchNumberCount, boolean containsBonusNumber){
            return matchNumberCount < MIN_MATCH_COUNT_FOR_PRIZE;
        }
    }
    , FIFTH_PLACE(5000, 3)
    , FOURTH_PLACE(50000, 4)
    , THIRD_PLACE(1500000, 5){
        @Override
        protected boolean matchRank(int matchNumberCount, boolean containsBonusNumber){
            return (getMatchNumberCount() == matchNumberCount) && !containsBonusNumber;
        }
    }
    , SECOND_PLACE(30000000,5){
        @Override
        protected boolean matchRank(int matchNumberCount, boolean containsBonusNumber){
            return (getMatchNumberCount() == matchNumberCount) && containsBonusNumber;
        }
    }
    , FIRST_PLACE(2000000000, 6);

    public static final int MIN_MATCH_COUNT_FOR_PRIZE = 3;

    private final int matchNumberCount;
    private final long prize;

    LottoRank(long prize, int matchNumberCount) {
        this.prize = prize;
        this.matchNumberCount = matchNumberCount;
    }

    public static LottoRank getRank(int matchNumberCount, boolean containsBonusNumber) {
        return Stream.of(LottoRank.values())
                .filter(rank -> rank.matchRank(matchNumberCount,containsBonusNumber))
                .findFirst().get();
    }

    protected boolean matchRank(int matchNumberCount, boolean containsBonusNumber){
        return this.matchNumberCount == matchNumberCount;
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
