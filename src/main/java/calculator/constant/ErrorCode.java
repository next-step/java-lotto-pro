package calculator.constant;

public enum ErrorCode {

    음의_정수가_입력되면_안됨("[ERROR] 음의 정수가 입력되었습니다. 양의 정수가 입력되어야 합니다."),
    정수값이_아님("[ERROR] 정수가 아닌 값이 입력되었습니다."),
    덧셈_결과_INT_양의_범위_넘김("[ERROR] 덧셈 결과, int의 양의 범위를 넘었습니다."),
    ;

    private final String errorMessage;

    ErrorCode(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
