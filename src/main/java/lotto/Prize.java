package lotto;

public enum Prize {
    FIRST(6, 2000000000),
    SECOND(5, 1500000),
    THIRD(4, 50000),
    FOURTH(3, 5000);

    private final int hit;
    private final int prize;

    Prize(int hit, int prize) {
        this.hit = hit;
        this.prize = prize;
    }

    public int getHit() {
        return hit;
    }

    public int getPrize() {
        return prize;
    }
}
