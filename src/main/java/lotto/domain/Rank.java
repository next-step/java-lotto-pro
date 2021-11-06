package lotto.domain;

public enum Rank {
    FOURTH(3, 5_000),
    THIRD(4, 50_000),
    SECOND(5, 1_500_000),
    FIRST(6, 2_000_000_000);

    private final int matchedCount;
    private final Money winningMoney;

    Rank(int matchedCount, long winningMoney) {
        this.matchedCount = matchedCount;
        this.winningMoney = Money.of(winningMoney);
    }

    public int getCount(Record record) {
        return record.get(matchedCount);
    }

    public Money getWinningMoney(Record record) {
        return winningMoney.multiply(getCount(record));
    }

    public int getMatchedCount() {
        return matchedCount;
    }

    public Money getWinningMoney() {
        return winningMoney;
    }
}
