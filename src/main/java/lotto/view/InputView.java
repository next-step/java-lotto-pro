package lotto.view;

import java.util.Scanner;

public final class InputView {

    private static final String INPUT_TOTAL_PAYMENT = "구입금액을 입력해 주세요.";
    private static final String INPUT_LAST_WEEK_WINNING_LOTTO_LINE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";
    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static int inputTotalPayment() {
        System.out.println(INPUT_TOTAL_PAYMENT);
        return Integer.parseInt(scanner.nextLine());
    }

    public static String inputLastWeekWinningLottoLine() {
        System.out.println(INPUT_LAST_WEEK_WINNING_LOTTO_LINE);
        return scanner.nextLine();
    }

    public static int inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER);
        return Integer.parseInt(scanner.nextLine());
    }
}
