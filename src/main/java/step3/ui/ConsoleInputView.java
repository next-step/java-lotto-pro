package step3.ui;

import java.util.Scanner;

public class ConsoleInputView implements InputView {
    private static final String REQUEST_PAYMENT = "구입금액을 입력해 주세요.";
    private static final String REQUEST_WINNING_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String REQUEST_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";
    private static final String REQUEST_MANUAL_COUNT = "수동으로 구매할 로또 수를 입력해 주세요.";
    private final Scanner sc = new Scanner(System.in);

    public int inputPayment() {
        System.out.println(REQUEST_PAYMENT);
        return sc.nextInt();
    }

    public String inputWinningNumber() {
        System.out.println(REQUEST_WINNING_NUMBER);
        return sc.next();
    }

    public String inputManualNumber() {
        return sc.next();
    }

    public String inputBonusNumber() {
        System.out.println(REQUEST_BONUS_NUMBER);
        return sc.next();
    }

    public int inputManualCount() {
        System.out.println(REQUEST_MANUAL_COUNT);
        return sc.nextInt();
    }

}
