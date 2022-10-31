package study.step3;

public enum Prize {
    FOURTH(3, 5000),
    THIRD(4, 50000),
    SECOND(5, 1500000),
    FIRST(6, 2000000000);

    private final int winNumber;
    private final int reward;

    Prize(int winNumber, int reward) {
        this.winNumber = winNumber;
        this.reward = reward;
    }

    public int getWinNumber() {
        return winNumber;
    }

    public int getReward() {
        return reward;
    }
}
