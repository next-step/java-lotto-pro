package lotto.view.strategy;

public class InputManualGameNumbers extends InputGameNumbers {

    private static final String MESSAGE = "\n수동으로 구매할 번호를 입력해 주세요.";

    @Override
    public String getMessage() {
        return MESSAGE;
    }

}
