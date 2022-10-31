package step4.view;

import step4.constant.InputMessage;

import java.util.Scanner;

public class InputView {

    private static final Scanner sc = new Scanner(System.in);

    public static String inputLottoBuyMoney() {
        System.out.println(InputMessage.INPUT_BUY_MONEY_MESSAGE);
        return sc.nextLine();
    }

    public static String inputWinnerLottoResult() {
        System.out.println();
        System.out.println(InputMessage.INPUT_WINNER_LOTTO_RESULT);
        return sc.nextLine();
    }

    public static String inputLottoBonusNumber() {
        System.out.println(InputMessage.INPUT_WINNER_LOTTO_BONUS_NUMBER);
        return sc.nextLine();
    }
}
