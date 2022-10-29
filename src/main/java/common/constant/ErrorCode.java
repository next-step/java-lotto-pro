package common.constant;

public enum ErrorCode {

    음의_정수가_입력되면_안됨("[ERROR] 음의 정수가 입력되었습니다. 양의 정수가 입력되어야 합니다."),
    정수값이_아님("[ERROR] 정수가 아닌 값이 입력되었습니다."),
    덧셈_결과_INT_양의_범위_넘김("[ERROR] 덧셈 결과, int의 양의 범위를 넘었습니다."),
    로또의_각_숫자는_1이상_45이하("[ERROR] 로또의 각 숫자는 1이상 45이하여야 합니다."),
    로또의_각_숫자는_중복_불가("[ERROR] 로또의 각 숫자는 중복될 수 없습니다."),
    로또는_6개의_숫자로_이루어져야함("[ERROR] 로또는 6개의 숫자로 이루어져야 합니다."),
    로또를_구매하기_위해서는_1000원_이상_필요("[ERROR] 로또를 구매하기 위해서는 1000원 이상 있어야 합니다."),
    돈은_양수여야_함("[ERROR] 돈은 0보다 크거나 같은 양의 정수여야 합니다."),
    ;

    private final String errorMessage;

    ErrorCode(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
