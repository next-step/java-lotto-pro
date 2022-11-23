package lotto2.model;

public enum WinningRank {
    FIRST(1, 6),
    SECOND(2, 5),
    THIRD(3, 5),
    FOURTH(4, 4),
    FIFTH(5, 3);

    private int rank;

    private int numberMatch;

    WinningRank(int rank, int numberMatch) {
        this.rank = rank;
        this.numberMatch = numberMatch;
    }
}
