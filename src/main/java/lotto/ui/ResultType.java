package lotto.ui;


/**
 * packageName : lotto.ui
 * fileName : OutputType
 * author : haedoang
 * date : 2021-11-05
 * description :
 */
public enum ResultType {
    PURCHASE, STATISTICS, YIELD;

    public boolean isPurchase() {
        return this == PURCHASE;
    }

    public boolean isStatistics() {
        return this == STATISTICS;
    }

    public boolean isYield() {
        return this == YIELD;
    }

}
