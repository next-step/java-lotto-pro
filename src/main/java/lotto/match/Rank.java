package lotto.match;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 3_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0,0);

    private int countOfMatch;
    private int amount;

    Rank(int countOfMatch, int amount) {
        this.countOfMatch = countOfMatch;
        this.amount = amount;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getAmount() {
        return amount;
    }

}
