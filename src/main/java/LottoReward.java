public enum LottoReward {
    MATCH3(3, 5000),
    MATCH4(4, 50000),
    MATCH5(5, 1500000),
    MATCH6(6, 2000000000);

    private int matchCount;
    private int reward;

    LottoReward(int matchCount, int reward) {
        this.matchCount = matchCount;
        this.reward = reward;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getReward() {
        return reward;
    }
}
