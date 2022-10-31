package lotto.view;

import java.util.Scanner;

public class LottoInputView {
    private static final Scanner scan = new Scanner(System.in);
    public static String readMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return scan.nextLine();
    }

    public static String readLottoWinNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scan.nextLine();
    }
}
