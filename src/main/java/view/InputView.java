package view;

import java.util.Scanner;

public class InputView {

    public static final Scanner scanner = new Scanner(System.in);

    public static int moneyInput() {
        System.out.println("구매 금액을 입력해주세요.");
        return scanner.nextInt();
    }

    public static String[] winNumberInput() {
        String message = scanner.next();
        return message.split(",");
    }
}
