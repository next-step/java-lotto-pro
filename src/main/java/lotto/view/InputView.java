package lotto.view;

import java.io.IOException;
import java.util.Scanner;

public class InputView {
    public static final Scanner SCANNER = new Scanner(System.in);
    private static final String START_LOTTO = "구입금액을 입력해주세요.";
    private static final String WINNING_LOTTO = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String INPUT_ERROR = "잘못된 금액을 입력하셨습니다.";

    public int printRequestAmount() {
        System.out.println(START_LOTTO);
        try {
            return SCANNER.nextInt();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_ERROR);
        } finally {
            SCANNER.nextLine();
        }
    }

    public String printRequestWinningLotto() {
        System.out.println(WINNING_LOTTO);
        String input = SCANNER.nextLine();
        return input;
    }
}
