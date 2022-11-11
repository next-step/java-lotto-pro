package lotto.ui.inputView;

import java.util.Scanner;

public class LottoMoneyInputView {

    public static final String PURCHASE_MONEY_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String NEED_NUMBER_MESSAGE = "숫자를 입력해 주세요.";

    public static int readPurchaseMoney() {
        System.out.println(PURCHASE_MONEY_INPUT_MESSAGE);
        try {
            return Integer.parseInt(new Scanner(System.in).nextLine());
        } catch (NumberFormatException e) {
            System.out.println(NEED_NUMBER_MESSAGE);
            return readPurchaseMoney();
        }
    }
}
