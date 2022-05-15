package lotto.view;

import java.util.Scanner;

public class InputView {

    private static final String ASK_PRICE_MESSAGE = "구입금액을 입력해 주세요.";

    private static Scanner scanner = new Scanner(System.in);

    public static int inputPrice() {
        System.out.println(ASK_PRICE_MESSAGE);
        return scanner.nextInt();
    }

}
