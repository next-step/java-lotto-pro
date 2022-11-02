package study.step4.models;

import study.step4.Rank;

public class Winner {
    private Lotto lotto;
    private Rank rank;

    public Winner(Lotto lotto, Rank rank) {
        this.lotto = lotto;
        this.rank = rank;
    }

    public boolean isSameRank(Rank rank) {
        return this.rank == rank;
    }

    public int reward() {
        return rank.getReward();
    }
}
