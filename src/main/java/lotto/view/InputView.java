package lotto.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static lotto.constants.ExceptionConstants.*;

public class InputView {
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    public static final String INPUT_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String INPUT_ANSWR_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";

    public static long inputMoney() {
        try {
            System.out.println(INPUT_MONEY_MESSAGE);
            return Long.parseLong(input());
        } catch (NumberFormatException ioe) {
            throw new IllegalArgumentException(INPUT_NUMBER_FORMAT_EXCEPTION);
        }
    }

    public static String inputAnswer() {
        System.out.println(INPUT_ANSWR_MESSAGE);
        return input();
    }

    private static String input() {
        try {
            return READER.readLine();
        } catch (IOException ioeException) {
            throw new IllegalArgumentException(INPUT_IO_EXCEPTION);
        }
    }
}
