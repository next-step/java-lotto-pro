package lotto.consts;

public enum WinningEnum {

    FIRST(1, 2000000000),
    // SECOND(),
    THIRD(3, 1500000),
    FOURTH(4, 50000),
    FIFTH(5, 5000),
    NONE(0, 0);

    private final int rank;
    private final int prize;

    WinningEnum(int rank, int prize) {
        this.rank = rank;
        this.prize = prize;
    }

    public int getRank() {
        return rank;
    }

    public int getPrize() {
        return prize;
    }
}
