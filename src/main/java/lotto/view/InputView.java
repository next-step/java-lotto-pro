package lotto.view;

import java.util.Scanner;

public class InputView {

    private static final String PURCHASING_LOTTO_DIRECTION = "구입금액을 입력해 주세요.";
    private static final String WINNING_LOTTO_DIRECTION = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String BONUS_LOTTO_DIRECTION = "보너스 볼을 입력해 주세요.";

    private static final Scanner scanner = new Scanner(System.in);

    public static void printPurchasingLottoDirection() {
        System.out.println(PURCHASING_LOTTO_DIRECTION);
    }

    public static String readLine() {
        return scanner.nextLine();
    }

    public static void printWinningLottoDirection() {
        System.out.println(WINNING_LOTTO_DIRECTION);
    }

    public static void printBonusLottoDirection() {
        System.out.println(BONUS_LOTTO_DIRECTION);
    }
}
