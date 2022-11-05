package study.message;

public enum LottoExceptionCode {

    INVALID_LOTTO_NUMBER("the given number is an invalid lotto number."),
    INSUFFICIENT_FUNDS("You must purchase at least one lotto."),
    NOT_MATCH_LOTTO_SIZE("The numbers entered are invalid as lotto numbers."),
    INVALID_BONUS_BALL("Bonus ball number must not be contained in the winning numbers."),
    FAILED_MANUAL_ORDER("You cannot manually order with invalid parameter values.");

    private static final String title = "[ERROR] ";
    private String message;

    LottoExceptionCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return title + message;
    }
}
