package step3.view;

import java.util.Scanner;

public class LottoConsoleView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static int inputPurchasingAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return SCANNER.nextInt();
    }

    public static String inputWinningNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return SCANNER.next();
    }
}
