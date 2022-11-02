package lotto.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static String printConsoleMsg(Messages msg) {
        System.out.println(msg.getMsg());
        String userInput = scanner.nextLine();
        return userInput;
    }

}
