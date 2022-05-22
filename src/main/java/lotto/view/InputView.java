package lotto.view;

import java.util.Scanner;

import static lotto.constants.Message.START_LOTTO;
import static lotto.constants.Message.WINNING_LOTTO;
import static stringAddCalculator.utils.Parse.INPUT_ERROR;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    public int printRequestAmount() {
        System.out.println(START_LOTTO);
        try {
            return SCANNER.nextInt();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_ERROR);
        } finally {
            SCANNER.nextLine();
        }
    }

    public String printRequestWinningLotto() {
        System.out.println(WINNING_LOTTO);
        String input = SCANNER.nextLine();
        return input;
    }
}
