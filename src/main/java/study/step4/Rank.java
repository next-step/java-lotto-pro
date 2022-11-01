package study.step4;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 1500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000),
    NONE(0, 0);

    private final int numberOfMatching;
    private final int reward;

    Rank(int numberOfMatching, int reward) {
        this.numberOfMatching = numberOfMatching;
        this.reward = reward;
    }

    public int getNumberOfMatching() {
        return numberOfMatching;
    }

    public int getReward() {
        return reward;
    }

    public static Rank valueOf(int countOfMatching) {
        if (countOfMatching == FIRST.numberOfMatching) {
            return Rank.FIRST;
        }
        if (countOfMatching == SECOND.numberOfMatching) {
            return Rank.SECOND;
        }
        if (countOfMatching == THIRD.numberOfMatching) {
            return Rank.THIRD;
        }
        if (countOfMatching == FOURTH.numberOfMatching) {
            return Rank.FOURTH;
        }
        return Rank.NONE;
    }
}
