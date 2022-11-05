package lotto.ui.inputView;

import java.util.Scanner;

public class LottoPurchaseInputView {

    public static int readPurchaseMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        Scanner s = new Scanner(System.in);
        try {
            return Integer.parseInt(s.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("숫자를 입력해 주세요.");
            return readPurchaseMoney();
        }
    }
}
