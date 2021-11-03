package lotto.view;

import lotto.exception.MyErrorCode;
import lotto.exception.MyException;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String ONLY_NUMBER_REGULAR_EXPRESSION = "^[0-9]*$";

    private InputView() {
    }

    public static int printInputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String inputMoney = scanner.nextLine();
        validInputMoney(inputMoney);
        return Integer.parseInt(inputMoney);
    }

    public static List<Integer> printInputWinningLotto() {
        System.out.println("지난 주 당첨 번호를 입력해주세요.");
        String inputWinningLottosText = scanner.nextLine();
        String[] inputWinningLottos = inputWinningLottosText.split(",");
        return Arrays.stream(inputWinningLottos)
                .map(number -> Integer.parseInt(number.trim()))
                .collect(Collectors.toList());
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
