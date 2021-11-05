package lotto.ui;

import lotto.common.Constants;
import lotto.domain.Lotto;
import lotto.domain.PurchasePrice;

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

    public static Object readLine(InputType type) {
        System.out.println(type.isPurchase() ? Constants.MSG_INPUT_PURCHASE_PRICE : type.isNumber() ? Constants.MSG_INPUT_LAST_WINNING_NUMBERS : "");
        try {
            String input = scanner.nextLine();
            return type.isPurchase() ? new PurchasePrice(input) : new Lotto(input);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return readLine(type);
        }
    }
}
