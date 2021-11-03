package lotto.exception;

public enum MyErrorCode {
    LESS_THAN_LOTTO_MONEY_AMOUNT("[ERROR]최소 로또 금액(1000원)보다 작게 입력하였습니다."),
    WRONG_INPUT_NUMBER("[ERROR] 잘못된 문자입니다. 숫자만 입력할 수 있습니다."),
    INVALID_RANGE_LOTTO_NUMBER("[ERROR] 잘못된 숫자를 입력하였습니다. 로또 숫자는 1~45 사이의 숫자입니다."),
    EXIST_DUPLICATION_NUMBER("[ERROR] 중복된 숫자를 가진 로또가 있습니다."),
    VALID_LOTTO_SIZE_SIX("[ERROR] 로또는 6개의 숫자가 있어야합니다."),
    INVALID_LOTTO_WIN_COUNT("[ERROR] 잘못된 당첨번호 개수를 입력하였습니다.");

    private String errorMessage;

    MyErrorCode(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String errorMessage() {
        return this.errorMessage;
    }
}
