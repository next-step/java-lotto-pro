package lotto.view;

import java.util.Scanner;

import static lotto.common.Messages.*;

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

    public static String bonusNumberString() {
        System.out.println(BONUS_BALL_NUMBER);
        return scanner.nextLine();
    }

    public static String passiveCountString() {
        System.out.println(PASSIVE_BALL_NUMBER_COUNT);
        return scanner.nextLine();
    }

    public static String inputPassiveNumbersString() {
        System.out.println(PASSIVE_BALL_NUMBERS);
        return scanner.nextLine();
    }
}
