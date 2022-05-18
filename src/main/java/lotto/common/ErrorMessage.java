package lotto.common;

public enum ErrorMessage {
    INVALID_RANGE_ERROR("로또 번호는 1 ~ 45 사이의 값이어야 합니다."),
    DUPLICATE_ERROR("로또 번호들은 중복이 되면 안됩니다."),
    INVALID_SIZE_ERROR("로또 번호는 6개만 가능합니다."),
    BONUS_NUMBER_DUPLICATE_ERROR("보너스 번호는 당첨번호와 중복되면 안됩니다."),
    EXCEED_MONEY_ERROR("구매할 수 있는 로또 개수를 초과하였습니다."),
    NUMBER_FORMAT_ERROR("숫자 형식으로 입력해야 합니다."),
    NULL_OR_EMPTY_ERROR("공백이나 Null 을 입력하면 안됩니다."),
    INVALID_MONEY_ERROR("금액을 잘못 입력했습니다."),
    MINIMUM_MONEY_ERROR("금액이 부족합니다. 최소 금액은 1000원입니다."),;

    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
