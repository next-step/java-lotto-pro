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
}
