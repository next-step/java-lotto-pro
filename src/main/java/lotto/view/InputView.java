package lotto.view;

import java.util.Scanner;

import static lotto.constants.Message.*;
import static stringAddCalculator.utils.Parse.INPUT_ERROR;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static int printRequestAmount() {
        System.out.println(START_LOTTO);
        try {
            return SCANNER.nextInt();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_ERROR);
        } finally {
            SCANNER.nextLine();
        }
    }

    public static int printRequestBonusNumber() {
        System.out.println(BONUS_NUMBER);
        try {
            return SCANNER.nextInt();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_ERROR);
        } finally {
            SCANNER.nextLine();
        }
    }

    public static String printRequestWinningLotto() {
        System.out.println(WINNING_LOTTO);
        String input = SCANNER.nextLine();
        return input;
    }
}
