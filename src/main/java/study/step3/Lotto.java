package study.step3;

public class Lotto {
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
