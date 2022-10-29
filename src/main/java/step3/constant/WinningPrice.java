package step3.constant;

public enum WinningPrice {

    GUESS_THREE(3, 5000),
    GUESS_FOUR(4, 50000),
    GUESS_FIVE(5, 1500000),
    GUESS_SIX(6, 2000000000);

    private int count;
    private int price;

    WinningPrice(int count, int price) {
        this.count = count;
        this.price = price;
    }

    public static int get(int sameNumber) {
        for (WinningPrice winningPrice2 : WinningPrice.values()) {
            if (winningPrice2.count == sameNumber) {
                return winningPrice2.price;
            }
        }
        return 0;
    }
}
