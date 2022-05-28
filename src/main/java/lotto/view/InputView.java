package lotto.view;

import java.util.Scanner;
import lotto.exception.NotNumberException;

public final class InputView {

    private static final String INPUT_TOTAL_PAYMENT = "구입금액을 입력해 주세요.";
    private static final String INPUT_MANUAL_COUNT = "\n수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String INPUT_MANUAL_LINES = "\n수동으로 구매할 번호를 입력해 주세요.";
    private static final String INPUT_LAST_WEEK_WINNING_LOTTO_LINE = "\n지난 주 당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";
    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static int inputTotalPayment() {
        System.out.println(INPUT_TOTAL_PAYMENT);
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println(new NotNumberException().getMessage());
            return inputTotalPayment();
        }
    }

    public static String inputManualLottoLine() {
        return scanner.nextLine();
    }

    public static String inputLastWeekWinningLottoLine() {
        System.out.println(INPUT_LAST_WEEK_WINNING_LOTTO_LINE);
        return scanner.nextLine();
    }

    public static int inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER);
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println(new NotNumberException().getMessage());
            return inputBonusNumber();
        }
    }

    public static int inputManualCount() {
        System.out.println(INPUT_MANUAL_COUNT);
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println(new NotNumberException().getMessage());
            return inputManualCount();
        }
    }

    public static void inputManualLottoLines() {
        System.out.println(INPUT_MANUAL_LINES);
    }
}
