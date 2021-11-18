package lotto.view;

import java.util.Scanner;

public class InputView {

    public static final String INPUT_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String INPUT_WINNING_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    public static final String INPUT_BONUS_BALL_MESSAGE = "보너스 볼을 입력해 주세요.";
    public static final String INPUT_COUNTS_OF_MANUAL_TICKETS = "수동으로 구매할 로또 수를 입력해 주세요";
    public static final String INPUT_LOTTO_NUMBERS_MESSAGE = "수동으로 구매할 번호를 입력해주세요.";

    Scanner scanner = new Scanner(System.in);

    public InputView() {
    }

    public String inputMoney() {
        System.out.println(INPUT_MONEY_MESSAGE);
        return scanner.nextLine();
    }

    public String inputWinningNumber() {
        System.out.println(INPUT_WINNING_NUMBER_MESSAGE);
        return scanner.nextLine();
    }

    public String inputBonusNumber() {
        System.out.println(INPUT_BONUS_BALL_MESSAGE);
        return scanner.nextLine();
    }

    public String inputCountsOfManualTickets() {
        System.out.println(INPUT_COUNTS_OF_MANUAL_TICKETS);
        return scanner.nextLine();
    }

    public String inputLottoNumbers() {
        System.out.println(INPUT_LOTTO_NUMBERS_MESSAGE);
        return scanner.next();
    }
}
