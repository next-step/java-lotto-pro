package step3.veiw;

import java.util.Scanner;

import static step3.constant.GameMessage.*;

public class InputView {

    private final static Scanner scanner = new Scanner(System.in);

    public static String inputPurchasePrice() {
        System.out.println(PURCHASE_PRICE_MESSAGE);
        return scanner.nextLine();
    }

    public static String inputBonusNumber() {
        System.out.println(BONUS_NUMBER_MESSAGE);
        return scanner.nextLine();
    }

    public static String inputLastWeekLottoNumber() {
        System.out.println(LAST_WEEK_LOTTO_NUMBER);
        return scanner.nextLine();
    }

    public static String inputManualCount() {
        System.out.println();
        System.out.println(MANUAL_COUNT_MESSAGE);
        return scanner.nextLine();
    }

    public static void inputManualLottoTitle() {
        System.out.println();
        System.out.println(MANUAL_NUMBER_MESSAGE);
    }

    public static String inputManualLotto() {
        return scanner.nextLine();
    }
}
