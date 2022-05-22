package lotto.view;

import java.util.Scanner;

public class InputView {
    public static final String INPUT_PURCHASE_PRICE_MESSAGE = "구입금액을 입력해주세요.";
    public static final String INPUT_CHECK_WINNING_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해주세요.";
    public static final String INPUT_BONUS_BALL_MESSAGE = "보너스 볼을 입력해 주세요.";
    public static final String INPUT_MANUAL_ISSUE_COUNT_MESSAGE = "수동으로 구매할 로또 수를 입력해주세요.";
    public static final String INPUT_MANUAL_ISSUE_NUMBER_MESSAGE = "수동으로 구매할 번호를 입력해주세요.";

    private final static Scanner scanner = new Scanner(System.in);

    public static void printInputPurchasePrice() {
        System.out.println(INPUT_PURCHASE_PRICE_MESSAGE);
    }

    public static String inputPurchasePrice() {
        return scanner.nextLine();
    }

    public static void printinputLottoNumber() {
        System.out.println(INPUT_CHECK_WINNING_NUMBER_MESSAGE);
    }

    public static String inputLottoNumber() {
        return scanner.nextLine();
    }

    public static String inputNumber() {
        return scanner.nextLine();
    }

    public static void printInputBonusBall() {
        System.out.println(INPUT_BONUS_BALL_MESSAGE);
    }

    public static void printInputManualIssueCount() {
        System.out.println(INPUT_MANUAL_ISSUE_COUNT_MESSAGE);
    }

    public static void printInputManualNumberCount() {
        System.out.println(INPUT_MANUAL_ISSUE_NUMBER_MESSAGE);
    }
}
