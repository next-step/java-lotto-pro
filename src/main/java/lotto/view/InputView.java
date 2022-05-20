package lotto.view;

import java.util.Scanner;

public class InputView {
    public static final String INPUT_PURCHASE_PRICE_MESSAGE = "구입금액을 입력해주세요.";
    public static final String INPUT_CHECK_WINNING_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해주세요.";
    public static final String INPUT_BONUS_BALL_MESSAGE = "보너스 볼을 입력해 주세요.";

    private final static Scanner scanner = new Scanner(System.in);

    public static void printInputPurchasePrice() {
        System.out.println(INPUT_PURCHASE_PRICE_MESSAGE);
    }

    public static String inputPurchasePrice() {
        return scanner.nextLine();
    }

    public static void printInputLastWeekWinningNumber() {
        System.out.println(INPUT_CHECK_WINNING_NUMBER_MESSAGE);
    }

    public static String inputLastWeekWinningNumber() {
        return scanner.nextLine();
    }

    public static void printInputBonusBall() {
        System.out.println(INPUT_BONUS_BALL_MESSAGE);
    }

    public String inputBonusBall() {
        return scanner.nextLine();
    }
}
