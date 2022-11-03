package lotto;

public enum WinningMoney {

    THREE_MATCH("3개 일치", 5_000L, 3),
    FOUR_MATCH("4개 일치", 50_000L, 4),
    FIVE_MATCH("5개 일치", 1_500_000L, 5),
    SIX_MATCH("6개 일치", 2_000_000_000L, 6);

    private final int count;
    private long money;
    private String message;

    WinningMoney(String message, long money, int count) {
        this.message = message;
        this.money = money;
        this.count = count;
    }

    public static WinningMoney find(int count) {
        for (WinningMoney winningMoney : values()) {
            if (winningMoney.count == count) {
                return winningMoney;
            }
        }
        throw new IllegalArgumentException("일치하는 enum 타입이 없습니다.");
    }

    public long getMoney() {
        return money;
    }
}
