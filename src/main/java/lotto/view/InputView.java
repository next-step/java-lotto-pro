package lotto.view;

import lotto.message.InputMessage;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputMoney() {
        System.out.println(InputMessage.INPUT_MONEY);
        return scanner.nextInt();
    }

    public static String inputWinningNumbers() {
        System.out.println(InputMessage.INPUT_WINNING_NUMBERS);
        return scanner.next();
    }
}
