package lotto.domain;

public enum Rank {
    FIRST(6, 2000000000),
    SECOND(5, 1500000),
    THIRD(4, 50000),
    FOURTH(3, 5000);

    private final int matchedCount;
    private final long winningMoney;

    Rank(int matchedCount, long winningMoney) {
        this.matchedCount = matchedCount;
        this.winningMoney = winningMoney;
    }

    public int getCount(Record record) {
        return record.get(matchedCount);
    }

    public long getWinningMoney(Record record) {
        return getCount(record) * winningMoney;
    }
}
