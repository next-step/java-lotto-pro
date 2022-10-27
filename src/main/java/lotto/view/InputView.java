package lotto.view;

import java.util.Scanner;

public class InputView {
    private static final String INVALID_NUMBER_MESSAGE = "입력값이 숫자가 아닙니다.";

    public static int getMoney() {
        ResultView.printGetMoney();

        try {
            return Integer.parseInt(read());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_NUMBER_MESSAGE, e);
        }
    }

    public static String getWiningNumber() {
        ResultView.printWinningNumber();
        return read();
    }

    private static String read() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
}
