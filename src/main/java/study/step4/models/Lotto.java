package study.step4.models;

import study.step4.Rank;

public class Lotto {
    public static final int SUB_LIST_START_INDEX = 0;
    public static final int SUB_LIST_END_INDEX = 6;

    private final Numbers numbers;
    private Rank rank;

    public Lotto(Numbers numbers) {
        this.numbers = numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    public void rank(Numbers winLottoNumbers) {
        int matchingCount = numbers.countNumberOfMatching(winLottoNumbers);
        this.rank = Rank.valueOf(matchingCount);
    }

    public boolean isSameRank(Rank rank) {
        return this.rank == rank;
    }

    public int reward() {
        return rank.getReward();
    }
}
