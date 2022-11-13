package study.step4.models;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Rank {
    NONE(0, 0, false, (numberOfMatching, hasBonusBallNumber) -> numberOfMatching == 0),
    FIFTH(3, 5_000, false, (numberOfMatching, hasBonusBallNumber) -> numberOfMatching == 3),
    FOURTH(4, 50_000, false, (numberOfMatching, hasBonusBallNumber) -> numberOfMatching == 4),
    THIRD(5, 1_500_000, false, (numberOfMatching, hasBonusBallNumber) -> numberOfMatching == 5 && !hasBonusBallNumber),
    SECOND(5, 30_000_000, true, (numberOfMatching, hasBonusBallNumber) -> numberOfMatching == 5 && hasBonusBallNumber),
    FIRST(6, 2_000_000_000, false, (numberOfMatching, hasBonusBallNumber) -> numberOfMatching == 6);

    private final int numberOfMatching;
    private final int reward;
    private final boolean hasBonusBallNumber;
    private final BiFunction<Integer, Boolean, Boolean> match;

    Rank(int numberOfMatching, int reward, boolean hasBonusBallNumber, BiFunction<Integer, Boolean, Boolean> match) {
        this.numberOfMatching = numberOfMatching;
        this.reward = reward;
        this.hasBonusBallNumber = hasBonusBallNumber;
        this.match = match;
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
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.match.apply(numberOfMatching, hasBonusBallNumber))
                .findFirst()
                .orElse(Rank.NONE);
    }

    public boolean isWinningRank() {
        return NONE != this;
    }
}
