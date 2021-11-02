package lotto.view;

import lotto.exception.MyErrorCode;
import lotto.exception.MyException;

import java.util.Scanner;
import java.util.regex.Pattern;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String ONLY_NUMBER_REGULAR_EXPRESSION = "^[0-9]*$";

    private InputView() {}

    public static int printInputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String inputMoney = scanner.nextLine();
        validInputMoney(inputMoney);
        return Integer.parseInt(inputMoney);
    }

    private static void validInputMoney(String inputMoney) {
        if (!isOnlyNumber(inputMoney)) {
            throw new MyException(MyErrorCode.WRONG_INPUT_NUMBER);
        }
    }

    private static boolean isOnlyNumber(String inputMoney) {
        return Pattern.matches(ONLY_NUMBER_REGULAR_EXPRESSION, inputMoney);
    }

}
