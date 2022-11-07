package study.step4;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2_000_000_000, false),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000, false),
    FOURTH(4, 50_000, false),
    FIFTH(3, 5_000, false),
    NONE(0, 0, false);

    private final int numberOfMatching;
    private final int reward;
    private final boolean hasBonusBallNumber;

    Rank(int numberOfMatching, int reward, boolean hasBonusBallNumber) {
        this.numberOfMatching = numberOfMatching;
        this.reward = reward;
        this.hasBonusBallNumber = hasBonusBallNumber;
    }

    public int getNumberOfMatching() {
        return numberOfMatching;
    }

    public int getReward() {
        return reward;
    }

    public boolean hasBonusBallNumber() {
        return hasBonusBallNumber;
    }

    public static Rank valueOf(int numberOfMatching, boolean hasBonusBallNumber) {
        if (numberOfMatching == SECOND.getNumberOfMatching()) {
            return Arrays.stream(Rank.values())
                    .filter(rank -> rank.hasNumberOfMatching(numberOfMatching))
                    .filter(rank -> rank.hasBonusBallNumber() == hasBonusBallNumber)
                    .findFirst()
                    .orElse(NONE);
        }
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.hasNumberOfMatching(numberOfMatching))
                .findFirst()
                .orElse(Rank.NONE);
    }

    private boolean hasNumberOfMatching(int numberOfMatching) {
        return this.numberOfMatching == numberOfMatching;
    }
}
