package lotto.ui;

import lotto.common.Constants;
import lotto.domain.Lotto;
import lotto.domain.PurchasePrice;

import java.util.Scanner;
/**
 *  피드백 내용 : 1) 함수의 기능을 분리하자. readLine에서는 readLine역할만 하자
 * */
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
    private InputView() {}

//    public static Object readLine(InputType type) {
//        ResultView.print(type.isPurchase() ? Constants.MSG_INPUT_PURCHASE_PRICE : type.isNumber() ? Constants.MSG_INPUT_LAST_WINNING_NUMBERS : "");
//        try {
//            String input = scanner.nextLine();
//            return type.isPurchase() ? new PurchasePrice(input) : new Lotto(input);
//        } catch (Exception e) {
//            ResultView.print(e.getMessage());
//            return readLine(type);
//        }
//    }

    public static String readLine() {
        return scanner.nextLine();
    }


}
