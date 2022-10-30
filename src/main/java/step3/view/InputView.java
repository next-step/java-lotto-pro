package step3.view;

import java.util.Scanner;

public class InputView {

    private static final String PURCHASE_AMOUNT = "구입 금액을 입력해주세요.";
    private static final String LAST_WINNING_NUMBER = "지난 주 당첨 번호를 입력해주세요.";
    private final static Scanner sc = new Scanner(System.in);

    public static int inputPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT);
        return sc.nextInt();
    }

    public String inputWinningNumber() {
        System.out.println(LAST_WINNING_NUMBER);
        return sc.nextLine();
    }

}
