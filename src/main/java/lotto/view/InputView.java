package lotto.view;

import java.util.Scanner;
import lotto.common.ViewMessage;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static String inputMoney() {
        System.out.println(ViewMessage.INPUT_MONEY_MESSAGE.getMessage());
        return scanner.nextLine();
    }

    public static String inputWinLotto() {
        System.out.println(ViewMessage.INPUT_WIN_LOTTO_MESSAGE.getMessage());
        return scanner.nextLine();
    }
}
