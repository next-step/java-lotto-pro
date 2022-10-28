package lotto.domain;

public class Lotto {
    private Rank rank;

    public Lotto(int matchCount) {
        this.rank = Rank.valueOf(matchCount);
    }

    public int getPrize() {
        return this.rank.getPrize();
    }
}
