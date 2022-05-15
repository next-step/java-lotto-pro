package lotto.common;

public enum ErrorMessage {
    INVALID_RANGE_ERROR("로또 번호는 1 ~ 45 사이의 값이어야 합니다."),
    DUPLICATE_ERROR("로또 번호들은 중복이 되면 안됩니다."),
    INVALID_SIZE_ERROR("로또 번호는 6개만 가능합니다.");

    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
