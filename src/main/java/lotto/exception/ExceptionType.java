package lotto.exception;

public enum ExceptionType {
    LESS_THAN_LOTTO_PRICE("지불금액이 로또 가격보다 낮습니다."),
    NOT_MATCHED_UNIT_PRICE("지불금액이 로또가격의 단위와 일치하지 않습니다."),
    INVALID_LOTTO_NUMBER_FORMAT("잘못된 로또 번호 형식입니다."),
    INVALID_NUMBER_SIZE("로또 번호는 1 부터 45 사이의 값만 올 수 있습니다."),
    IS_NOT_OVERLAP_WINNING_NUMBER("당첨 번호는 중복이 존재할 수 없습니다."),
    INVALID_LOTTO_NUMBER_SIZE("로또의 번호 갯수가 6개가 아닙니다."),
    INVALID_NUMBER_FORMAT("번호의 형식이 숫자가 아닙니다."),
    ALREADY_EXISTS_WINNINGS_NUMBER("보너스 번호가 당첨번호에 이미 존재합니다."),
    IS_LACK_OF_PRICE("로또를 구매할 금액이 부족합니다.");
    private final String message;

    ExceptionType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
