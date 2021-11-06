package lotto.domain;

public enum Rank {
    FOURTH(3, 5_000),
    THIRD(4, 50_000),
    SECOND(5, 1_500_000),
    FIRST(6, 2_000_000_000);

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

    public int getMatchedCount() {
        return matchedCount;
    }

    public long getWinningMoney() {
        return winningMoney;
    }
}
