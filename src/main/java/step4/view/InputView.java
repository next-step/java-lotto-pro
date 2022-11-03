package step4.view;

import java.util.Scanner;

public class InputView {
    public static final String INPUT_BUY_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String INPUT_WINNER_LOTTO_RESULT = "지난 주 당첨 번호를 입력해 주세요.";
    public static final String INPUT_WINNER_LOTTO_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";

    private static final Scanner sc = new Scanner(System.in);

    public static String inputLottoBuyMoney() {
        System.out.println(INPUT_BUY_MONEY_MESSAGE);
        return sc.nextLine();
    }

    public static String inputWinnerLottoResult() {
        System.out.println(INPUT_WINNER_LOTTO_RESULT);
        return sc.nextLine();
    }

    public static String inputLottoBonusNumber() {
        System.out.println(INPUT_WINNER_LOTTO_BONUS_NUMBER);
        return sc.nextLine();
    }
}
