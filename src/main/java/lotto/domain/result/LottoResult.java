package lotto.domain.result;

import lotto.domain.matcher.count.MatchCount;

public enum LottoResult {

    THREE(3, 5000, false),
    FOUR(4, 50000, false),
    FIVE(5, 1500000, false),
    FIVE_BONUS(5, 30000000, true),
    SIX(6, 2000000000, false);

    private static final String RESULT_MATCH_COUNT_TEXT = "개 일치 (";
    private static final String RESULT_MATCH_BONUS_COUNT_TEXT = "개 일치, 보너스 볼 일치(";
    private static final String RESULT_MONEY_TEXT = "원)- ";
    private static final String RESULT_TOTAL_COUNT_TEXT = "개";
    private static final int DEFAULT_PROFIT = 0;
    private static final int CLEAR_TOTAL_COUNT = 0;
    private static final int NOT_BONUS_MATCH_COUNT = 5;
    private int matchCount;
    private int money;
    private boolean isBonus;
    private int totalCount;

    LottoResult(int matchCount, int money, boolean isBonus) {
        this.matchCount = matchCount;
        this.money = money;
        this.isBonus = isBonus;
    }

    public void calculateTotalCount(MatchCount matchCount) {
        if (matchCount.isEquals(this.matchCount)) {
            addTotalCount(matchCount);
        }
    }

    private void addTotalCount(MatchCount matchCount) {
        if (this.matchCount != NOT_BONUS_MATCH_COUNT) {
            totalCount++;
        }
        if (this == FIVE && !matchCount.isMatchBonus()) {
            totalCount++;
        }
        if (this == FIVE_BONUS && matchCount.isMatchBonus()) {
            totalCount++;
        }
    }

    public int profit() {
        int profit = DEFAULT_PROFIT;
        for (int i = 0; i < totalCount; i++) {
            profit += money;
        }
        totalCount = CLEAR_TOTAL_COUNT;
        return profit;
    }

    @Override
    public String toString() {
        return matchCount
                + (isBonus ? RESULT_MATCH_BONUS_COUNT_TEXT : RESULT_MATCH_COUNT_TEXT)
                + money + RESULT_MONEY_TEXT
                + totalCount + RESULT_TOTAL_COUNT_TEXT;
    }
}
