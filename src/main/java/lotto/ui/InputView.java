package lotto.ui;

import lotto.common.Constants;

import java.util.Scanner;

/**
 * packageName : lotto.ui
 * fileName : InputView
 * author : haedoang
 * date : 2021-11-05
 * description :
 */
public class InputView {
    private static Scanner scanner;

    static {
        scanner = new Scanner(System.in);
    }

    public static String readLine(InputType type) {
        System.out.println(type.isPurchase() ? Constants.MSG_INPUT_PURCHASE_PRICE : type.isNumber() ? Constants.MSG_INPUT_LAST_WINNING_NUMBERS : "");
        return scanner.next();
    }
}
