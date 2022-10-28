package lotto.constant;

public enum ErrorCode {

    로또의_각_숫자는_1이상_45이하("[ERROR] 로또의 각 숫자는 1이상 45이하여야 합니다."),
    로또의_각_숫자는_중복_불가("[ERROR] 로또의 각 숫자는 중복될 수 없습니다."),
    로또는_6개의_숫자로_이루어져야함("[ERROR] 로또는 6개의 숫자로 이루어져야 합니다."),
    로또를_구매하기_위해서는_1000원_이상_필요("[ERROR] 로또를 구매하기 위해서는 1000원 이상 있어야 합니다."),
    ;

    private final String errorMessage;

    ErrorCode(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
