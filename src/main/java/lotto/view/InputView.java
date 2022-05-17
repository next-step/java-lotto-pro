package lotto.view;

import java.util.Scanner;
import lotto.constants.MessageConstants;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    private static int inputPrice() {
        int price = scanner.nextInt();
        scanner.nextLine();
        return price;
    }

    private static String inputString() {
        return scanner.nextLine();
    }

    public static int inputPurchaseAmount() {
        System.out.println(MessageConstants.INPUT_PURCHASE_AMOUNT);
        return inputPrice();
    }

    public static String inputWinningNumbers() {
        System.out.println(MessageConstants.INPUT_LAST_WEEK_WINNING_NUMBERS);
        return inputString();
    }

    public static String inputBonusNumber() {
        System.out.println(MessageConstants.INPUT_BONUS_NUMBERS);
        return inputString();
    }
}
