package lotto.view;

/**
 * 사용자에게 당첨 번호를 입력하도록 요구하는 메시지를 출력한다.
 */
public class DemandWinningNumbersInputPrinter {
    private static final String DEMAND_WINNING_NUMBERS_INPUT_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";

    public static void print() {
        System.out.println(DEMAND_WINNING_NUMBERS_INPUT_MESSAGE);
    }
}
