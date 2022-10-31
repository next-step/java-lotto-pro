package step3.veiw;

import step3.model.LottoGenerator;

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

}
