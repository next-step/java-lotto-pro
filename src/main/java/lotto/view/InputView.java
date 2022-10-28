package lotto.view;

import java.util.Scanner;

public class InputView {

    private static final String INPUT_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";

    private static final String INPUT_BEFORE_WEEK_WINNING_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";

    private static final Scanner scanner = new Scanner(System.in);

    public static String inputAmount() {
        System.out.println(INPUT_AMOUNT_MESSAGE);

        return scanner.nextLine();
    }

    public static String inputWinningNumbers() {
        System.out.println(INPUT_BEFORE_WEEK_WINNING_NUMBER_MESSAGE);

        return scanner.nextLine();
    }
}
