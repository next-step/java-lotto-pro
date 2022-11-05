package lotto.ui.inputView;

import java.util.Scanner;

public class LottoMoneyInputView {

    public static int readPurchaseMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        try {
            return Integer.parseInt(new Scanner(System.in).nextLine());
        } catch (NumberFormatException e) {
            System.out.println("숫자를 입력해 주세요.");
            return readPurchaseMoney();
        }
    }
}
