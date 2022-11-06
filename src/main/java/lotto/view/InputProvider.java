package lotto.view;

import java.util.Scanner;

public class InputProvider {
    private final static Scanner SCANNER = new Scanner(System.in);
    private static final String ENTER_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String ENTER_WINNING_NUMBERS = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String ENTER_BONUS_NUMBERS = "보너스 볼을 입력해 주세요.";

    public static Integer purchaseAmount() {
        System.out.println(ENTER_PURCHASE_AMOUNT);
        return SCANNER.nextInt();
    }

    public static String lottoNumbers() {
        System.out.println(ENTER_WINNING_NUMBERS);
        SCANNER.nextLine();
        return SCANNER.nextLine();
    }

    public static int bonusNumber() {
        System.out.println(ENTER_BONUS_NUMBERS);
        return SCANNER.nextInt();
    }
}
