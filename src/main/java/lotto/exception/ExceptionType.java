package lotto.exception;

public enum ExceptionType {
    LESS_THAN_LOTTO_PRICE("지불금액이 로또 가격보다 낮습니다."),
    NOT_MATCHED_UNIT_PRICE("지불금액이 로또가격의 단위와 일치하지 않습니다."),
    INVALID_WINNING_NUMBER_FORMAT("잘못된 당첨 번호 형식입니다."),
    INVALID_NUMBER_SIZE("당첨 번호는 1 부터 45 사이의 값만 올 수 있습니다."),
    IS_NOT_OVERLAP_WINNING_NUMBER("당첨 번호는 중복이 존재할 수 없습니다.");

    private final String message;

    ExceptionType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
