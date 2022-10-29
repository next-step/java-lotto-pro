package view;

import java.util.Scanner;

public class InputReader {
    private static final Scanner scanner = new Scanner(System.in);

    private static final String INQUIRE_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";

    public static String inquirePurchaseAmount() {
        System.out.println(INQUIRE_PURCHASE_AMOUNT_MESSAGE);
        return scanner.nextLine();
    }
}
