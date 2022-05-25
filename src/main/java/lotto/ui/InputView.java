package lotto.ui;

import java.util.Scanner;
import lotto.Lotto;

public class InputView {
    static final String PRINT_INPUT_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    static final String PRINT_INPUT_WINNING_LOTTO_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    static final String PRINT_INPUT_BONUS_BALL_LOTTO_MESSAGE = "보너스 볼 입력해 주세요.";
    static final String WINNING_LOTTO_DELIMITER = ",";
    static final Scanner scanner = new Scanner(System.in);

    public static int getMoneyInput() {
        System.out.println(PRINT_INPUT_MONEY_MESSAGE);
        String inputMoney = scanner.nextLine();

        return validateMoneyInput(inputMoney);
    }

    public static int validateMoneyInput(String inputMoney) {
        int money;
        try {
            money = Integer.parseInt(inputMoney);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException("금액은 숫자입니다.");
        }
        if (money < 0) {
            throw new IllegalArgumentException("금액은 음수일 수 없습니다.");
        }
        return money;
    }

    public static Lotto getWinningLottoInput() {
        System.out.println(PRINT_INPUT_WINNING_LOTTO_MESSAGE);
        String winningLottoString = scanner.nextLine();

        String[] splitWinningLottoString = winningLottoString.split(WINNING_LOTTO_DELIMITER);

        return new Lotto(splitWinningLottoString);
    }

    public static int getBonusNumberInput(Lotto winningLotto) {
        System.out.println(PRINT_INPUT_BONUS_BALL_LOTTO_MESSAGE);
        String bonusBall = scanner.nextLine();

        return Lotto.validateBonus(winningLotto, bonusBall);
    }
}
