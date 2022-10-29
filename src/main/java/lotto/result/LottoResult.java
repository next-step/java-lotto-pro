package lotto.result;

public enum LottoResult {

    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    SIX(6, 2000000000);

    private static final String RESULT_MATCH_COUNT_TEXT = "개 일치 (";
    private static final String RESULT_MONEY_TEXT = "원)- ";
    private static final String RESULT_TOTAL_COUNT_TEXT = "개";
    private static final int DEFAULT_PROFIT = 0;
    private static final int START_TOTAL_COUNT = 0;
    private static final int CLEAR_TOTAL_COUNT = 0;
    private int matchCount;
    private int money;
    private int totalCount;

    LottoResult(int matchCount, int money) {
        this.matchCount = matchCount;
        this.money = money;
    }

    public void calculateTotalCount(int matchCount) {
        if (this.matchCount == matchCount) {
            totalCount++;
        }
    }

    public int profit() {
        int profit = DEFAULT_PROFIT;
        for (int i = START_TOTAL_COUNT; i < totalCount; i++) {
            profit += money;
        }
        totalCount = CLEAR_TOTAL_COUNT;
        return profit;
    }

    @Override
    public String toString() {
        return matchCount + RESULT_MATCH_COUNT_TEXT + money + RESULT_MONEY_TEXT
                + totalCount + RESULT_TOTAL_COUNT_TEXT;
    }
}
