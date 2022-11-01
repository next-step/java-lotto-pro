package lotto.view;

public enum Messages {

    ASK_PAYMENT("구입 금액을 입력해주세요."),
    NOTIFY_PURCHASES("개를 구매했습니다.");
    private String msg;

    Messages(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return this.msg;
    }

}
