package lotto.view;

import java.util.Scanner;

public class InputConsole {

    private static final Scanner SCANNER = new Scanner(System.in);

    private InputConsole() {
    }

    public static String inputMoneyForPurchaseLotto() {
        System.out.println("구입금액을 입력해 주세요.");
        return SCANNER.nextLine();
    }

    public static String inputWinningLottoNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return SCANNER.nextLine();
    }

    public static String inputBonusLottoNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return SCANNER.nextLine();
    }

    public static String inputBuyManuallyNumber() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return SCANNER.nextLine();
    }

}
