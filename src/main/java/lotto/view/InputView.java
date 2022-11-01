package lotto.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    private static final String INPUT_MESSAGE_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String INPUT_MESSAGE_LAST_WEEKS_WINNING_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String INPUT_MESSAGE_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    private InputView() {
    }

    public static String inputPurchaseAmount() {
        OutputView.println(INPUT_MESSAGE_PURCHASE_AMOUNT);
        return scanner.nextLine();
    }

    public static String inputLastWeeksWinningNumber() {
        OutputView.printNewLine();
        OutputView.println(INPUT_MESSAGE_LAST_WEEKS_WINNING_NUMBER);
        return scanner.nextLine();
    }

    public static int inputBonusNumber() {
        OutputView.println(INPUT_MESSAGE_BONUS_NUMBER);
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            throw new IllegalArgumentException(OutputView.ERROR_MESSAGE_INPUT_ONLY_NUMBER);
        }
    }
}
