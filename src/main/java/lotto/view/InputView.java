package lotto.view;

import java.util.Scanner;

public class InputView {
    private static final String INVALID_NUMBER_MESSAGE = "입력값이 숫자가 아닙니다.";
    private static final String WHITE_SPACE_REGEX_STRING = "\\s";
    private static final String EMPTY = "";

    private InputView() {}

    public static int getMoney() {
        OutputView.printGetMoney();

        try {
            return Integer.parseInt(read());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_NUMBER_MESSAGE, e);
        }
    }

    public static String getWiningNumber() {
        OutputView.printWinningNumber();
        return read().replaceAll(WHITE_SPACE_REGEX_STRING, EMPTY);
    }

    private static String read() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
}
