package lotto.view;

import java.util.Scanner;

import static lotto.common.Messages.LAST_WEEK_WINNING_NUMBER;
import static lotto.common.Messages.START_MESSAGE;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static String inputMoney() {
        System.out.println(START_MESSAGE);
        return scanner.nextLine();
    }

    public static String lastWeekWinningNumberString() {
        System.out.println(LAST_WEEK_WINNING_NUMBER);
        return scanner.nextLine();
    }
}
