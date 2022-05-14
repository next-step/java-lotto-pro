package lotto.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String MONEY_INPUT_MESSAGE = "구입금액을 입력해 주세요.";

    public static String readInput() {
        System.out.println(MONEY_INPUT_MESSAGE);
        return scanner.nextLine();
    }

}
