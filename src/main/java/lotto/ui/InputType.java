package lotto.ui;

/**
 * packageName : lotto.ui
 * fileName : InputType
 * author : haedoang
 * date : 2021-11-05
 * description :
 */
public enum InputType {
    PURCHASE, NUMBER;

    public boolean isPurchase() {
        return this == PURCHASE;
    }

    public boolean isNumber() {
        return this == NUMBER;
    }
}

