package lotto.view;

import lotto.exception.LottoException;
import lotto.exception.LottoExceptionType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputView {
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private static final String INPUT_MONEY_MESSAGE = "구입 금액을 입력해 주세요.";
    private static final String INPUT_ANSWER_MESSAGE = "\n지난 주 당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_MESSAGE = "보너스 볼을 입력해 주세요.";
    private static final String INPUT_MANUAL_BUY_COUNT_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String INPUT_LOTTO_NUMBER = "수동으로 구매할 번호를 입력해 주세요.";

    public static long inputMoney() {
        System.out.println(INPUT_MONEY_MESSAGE);
        return inputLong();
    }

    public static String inputAnswer() {
        System.out.println(INPUT_ANSWER_MESSAGE);
        return input();
    }

    public static String inputBonusAnswer() {
        System.out.println(INPUT_BONUS_MESSAGE);
        return input();
    }

    public static int inputManualBuyCount() {
        System.out.println(INPUT_MANUAL_BUY_COUNT_MESSAGE);
        return inputInt();
    }

    public static String inputLottoNumber() {
        System.out.println(INPUT_LOTTO_NUMBER);
        return input();
    }


    private static int inputInt() {
        try {
            return Integer.parseInt(input());
        } catch (NumberFormatException ioe) {
            throw new LottoException(LottoExceptionType.INPUT_NUMBER_FORMAT);
        }
    }

    private static long inputLong() {
        try {
            return Long.parseLong(input());
        } catch (NumberFormatException ioe) {
            throw new LottoException(LottoExceptionType.INPUT_NUMBER_FORMAT);
        }
    }

    private static String input() {
        try {
            return READER.readLine();
        } catch (IOException ioeException) {
            throw new LottoException(LottoExceptionType.INPUT_IO);
        }
    }
}
