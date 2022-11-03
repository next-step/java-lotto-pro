package play.ui;

import java.util.Scanner;

public class InputView {
    private static final Scanner sc = new Scanner(System.in);

    public static String inputMoneyPurchaseLotto() {
        System.out.println("구입금액을 입력해 주세요.");
        String inputMoney = sc.nextLine();
        return inputMoney;
    }

    public static String inputWinningLottoNumber() {
        System.out.println();
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String winningNumber = sc.nextLine();
        sc.close();
        return winningNumber;
    }
}
