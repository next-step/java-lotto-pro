package lotto.view;

import lotto.domain.Money;

import java.util.Scanner;

import static lotto.common.Messages.LAST_WEEK_WINNING_NUMBER;
import static lotto.common.Messages.START_MESSAGE;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static Money inputMoney() {
        System.out.println(START_MESSAGE);
        String inputString = scanner.nextLine();

        return new Money(inputString);
    }

    public static String lastWeekWinningNumber() {
        System.out.println(LAST_WEEK_WINNING_NUMBER);
        return scanner.nextLine();
    }
}
