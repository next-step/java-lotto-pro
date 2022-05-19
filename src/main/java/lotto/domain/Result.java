package lotto.domain;

public class Result {
    private int matches;
    private int count;
    private int reward;

    public Result(int matches, int count) {
        this.matches = matches;
        this.count = count;
        this.reward = Reward.findAmount(matches);
    }

    public int matches() {
        return matches;
    }

    public int count() {
        return count;
    }

    public int reward() {
        return reward;
    }

    public int sum() {
        return count * reward;
    }
}
