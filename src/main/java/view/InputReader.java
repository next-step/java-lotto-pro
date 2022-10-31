package view;

import java.util.Scanner;

public class InputReader {
    private static final Scanner scanner = new Scanner(System.in);

    private static final String INQUIRE_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INQUIRE_LAST_WEEK_WINNING_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String INQUIRE_BONUS_BALL_MESSAGE = "보너스 볼을 입력해 주세요.";

    public static String readPurchaseAmount() {
        System.out.println(INQUIRE_PURCHASE_AMOUNT_MESSAGE);
        return scanner.nextLine();
    }

    public static String readBonusBall() {
        System.out.println(INQUIRE_BONUS_BALL_MESSAGE);
        return scanner.nextLine();
    }

    public static String readLastWeekWinningNumber() {
        System.out.println();
        System.out.println(INQUIRE_LAST_WEEK_WINNING_NUMBER_MESSAGE);
        return scanner.nextLine();
    }
}
