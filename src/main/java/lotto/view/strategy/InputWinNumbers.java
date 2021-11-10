package lotto.view.strategy;

public class InputWinNumbers extends InputGameNumbers {

    private static final String MESSAGE = "\r\n지난 주 당첨 번호를 입력해 주세요.";

    @Override
    public String getMessage() {
        return MESSAGE;
    }

}
