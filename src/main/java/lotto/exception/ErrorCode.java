package lotto.exception;

public enum ErrorCode {
    INPUT_VIEW("InputView 생성자는 호출하면 안됩니다."),
    OUTPUT_VIEW("InputView 생성자는 호출하면 안됩니다.")
    ;

    private String msg;

    ErrorCode(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
