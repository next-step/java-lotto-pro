package lotto.ui;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String INPUT_BUY_PRICE_MESSAEG = "구매금액을 입력해 주세요.";
    private static final String INPUT_WINNING_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";

    public static String getBuyPrice() {
        System.out.println(INPUT_BUY_PRICE_MESSAEG);
        return scanner.nextLine();
    }

    public static String getWinningNumbers() {
        System.out.println(INPUT_WINNING_MESSAGE);
        return scanner.nextLine();
    }
}
