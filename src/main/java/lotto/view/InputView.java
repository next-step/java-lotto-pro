package lotto.view;

public class InputView {
    private static final String INPUT_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBERS_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";

    public String inputMoneyView() {
        return INPUT_MONEY_MESSAGE;
    }

    public String inputWinningNumbersView() {
        return INPUT_WINNING_NUMBERS_MESSAGE;
    }
}
