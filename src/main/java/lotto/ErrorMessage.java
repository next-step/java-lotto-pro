package lotto;

public enum ErrorMessage {

    LOTTO_NUMBER_BOUND_ERROR("로또 숫자는 1~45 사이의 숫자여야 합니다."),
    LOTTO_NUMBER_DUPLICATE_ERROR("로또 숫자는 중복될 수 없습니다."),
    LOTTO_NUMBER_SIZE_ERROR("로또 숫자는 6개 여야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
