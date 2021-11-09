package lotto.view;

import java.util.Scanner;

public class InputView {
    public static final String PURCHASE_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String WINNING_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String BONUS_BALL_MESSAGE = "보너스 볼을 입력해 주세요.";
    private Scanner scanner = new Scanner(System.in);

    public String inputMoney() {
        System.out.println(PURCHASE_MESSAGE);
        return scanner.nextLine();
    }

    public String inputWiningLotto() {
        System.out.println(WINNING_NUMBER_MESSAGE);
        return scanner.nextLine();
    }

    public String inputBonusBall() {
        System.out.println(BONUS_BALL_MESSAGE);
        return scanner.nextLine();
    }
}
