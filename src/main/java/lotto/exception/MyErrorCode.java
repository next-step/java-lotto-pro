package lotto.exception;

public enum MyErrorCode {
    LESS_THAN_LOTTO_MONEY_AMOUNT("[ERROR]최소 로또 금액(1000원)보다 작게 입력하였습니다."),
    WRONG_INPUT_NUMBER("[ERROR] 잘못된 문자입니다. 숫자만 입력할 수 있습니다.");

    private String errorMessage;

    MyErrorCode(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String errorMessage() {
        return this.errorMessage;
    }
}
