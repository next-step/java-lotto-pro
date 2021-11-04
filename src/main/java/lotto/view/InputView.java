package lotto.view;

public class InputView {
    public static final String PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    public static final String WINNING_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";
    public static final String WINNING_STATS = "당첨 통계";
    public static final String WINNING_LINE = "---------";

    public static void printMessage(String message) {
        System.out.println(message);
    }
}
