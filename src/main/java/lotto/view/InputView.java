package lotto.view;

import java.util.Scanner;

import static stringAddCalculator.utils.Parse.INPUT_ERROR;

public class InputView {
    private static final String START_LOTTO = "구입금액을 입력해주세요.";
    private static final String WINNING_LOTTO = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER = "보너스 볼을 입력해 주세요.";
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
