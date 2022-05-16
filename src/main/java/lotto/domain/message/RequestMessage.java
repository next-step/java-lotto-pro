package lotto.domain.message;

public enum RequestMessage {
    PAYMENT("구입금액을 입력해 주세요."),
    WINNING_NUMBERS("지난 주 당첨 번호를 입력해 주세요."),
    ;

    private final String message;

    RequestMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
