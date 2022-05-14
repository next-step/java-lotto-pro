package lotto.exception;

public enum ExceptionType {
    LESS_THAN_LOTTO_PRICE("지불금액이 로또 가격보다 낮습니다."),
    NOT_MATCHED_UNIT_PRICE("지불금액이 로또가격의 단위와 일치하지 않습니다.");

    private final String message;

    ExceptionType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
