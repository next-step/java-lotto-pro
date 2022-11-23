package lotto2.model;

public enum LottoPrizeEnum {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000);

    private int numberMatch;
    private int prize;

    LottoPrizeEnum(int numberMatch, int prize) {
        this.numberMatch = numberMatch;
        this.prize = prize;
    }

    public int getNumberMatch() {
        return numberMatch;
    }

    public int getPrize() {
        return prize;
    }
}
