package study.step4;

import java.util.Arrays;

public enum Rank {
    NONE(0, 0, false, false, ""),
    FIFTH(3, 5_000, false, true, "3개 일치 (5000원)"),
    FOURTH(4, 50_000, false, true, "4개 일치 (50000원)"),
    THIRD(5, 1_500_000, false, true, "5개 일치 (1500000원)"),
    SECOND(5, 30_000_000, true, true, "5개 일치, 보너스 볼 일치(30000000원)"),
    FIRST(6, 2_000_000_000, false, true, "6개 일치 (2000000000원)");

    private final int numberOfMatching;
    private final int reward;
    private final boolean hasBonusBallNumber;
    private final boolean show;
    private final String message;

    Rank(int numberOfMatching, int reward, boolean hasBonusBallNumber, boolean show, String message) {
        this.numberOfMatching = numberOfMatching;
        this.reward = reward;
        this.hasBonusBallNumber = hasBonusBallNumber;
        this.show = show;
        this.message = message;
    }

    public int getNumberOfMatching() {
        return numberOfMatching;
    }

    public int getReward() {
        return reward;
    }

    public boolean isShow() {
        return show;
    }

    public String getMessage() {
        return message;
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
