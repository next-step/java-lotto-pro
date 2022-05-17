package lotto.domain;

public enum LottoNumbersCondition {
    AMOUNT_OF_NUMBERS(6),
    MINIMUM_NUMBER(1),
    MAXIMUM_NUMBER(45),
    ;

    private final int condition;

    LottoNumbersCondition(final int condition) {
        this.condition = condition;
    }

    public int getCondition() {
        return condition;
    }
}
