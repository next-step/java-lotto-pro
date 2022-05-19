package lotto.domain;

public enum LottoCondition {
    TICKET_COST(1000),
    AMOUNT_OF_NUMBERS(6),
    MINIMUM_NUMBER(1),
    MAXIMUM_NUMBER(45),
    ;

    private final int condition;

    LottoCondition(final int condition) {
        this.condition = condition;
    }

    public int getCondition() {
        return condition;
    }
}
