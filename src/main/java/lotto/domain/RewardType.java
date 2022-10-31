package lotto.domain;

public enum RewardType {
    FIRST(6, 2000000000),
    SECOND(5,1500000),
    THIRD(4,50000),
    FOURTH(3,5000),
    MISS(-1,0);

    private final int countOfMath;
    private final int rewardPrice;

    RewardType(int countOfMath, int rewardPrice) {
        this.countOfMath = countOfMath;
        this.rewardPrice = rewardPrice;
    }

    public static RewardType match(Lotto lotto, Lotto winLotto) {
        int matchCount = lotto.countMatchNumber(winLotto);
        return findRewardType(matchCount);
    }

    private static RewardType findRewardType(int matchCount) {
        if (matchCount == 6)
            return FIRST;
        if (matchCount == 5)
            return SECOND;
        if (matchCount == 4)
            return THIRD;
        if (matchCount == 3)
            return FOURTH;
        return MISS;
    }

    public Integer getRewardPrice() {
        return rewardPrice;
    }
}
