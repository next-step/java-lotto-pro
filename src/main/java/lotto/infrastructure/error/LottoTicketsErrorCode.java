package lotto.infrastructure.error;

public enum LottoTicketsErrorCode {

    NOT_ALLOW_NULL_OR_EMPTY("LottoTickets가 null 또는 empty입니다.");

    private final String message;

    LottoTicketsErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
