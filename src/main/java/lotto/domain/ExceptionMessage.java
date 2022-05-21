package lotto.domain;

public enum ExceptionMessage {
    ILLEGAL_SIZE("유효하지 않은 번호 개수"),
    NUMBER_DUPLICATE("번호 중복"),
    NOT_UNSIGNED_INT("자연수만 가능"),
    ZERO("0일 수 없습니다."),
    OUT_OF_BOUNDS("범위를 벗어남"),
    NOT_ENOUGH_AMOUNT("금액이 모자랍니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
