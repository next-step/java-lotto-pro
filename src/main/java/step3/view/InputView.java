package step3.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final String LOTTO_NUMBER_DELIMITER = ",";

    private InputView() {
    }

    public static Integer inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return inputNumber();
    }

    public static List<Integer> inputWinnerNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return Arrays.stream(inputText().split(LOTTO_NUMBER_DELIMITER))
                .map(text -> Integer.parseInt(text.trim()))
                .collect(Collectors.toList());
    }

    private static int inputNumber() {
        try {
            return Integer.parseInt(inputText());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력해주세요.");
        }
    }

    private static String inputText() {
        Scanner scan = new Scanner(System.in);
        return scan.next();
    }
}
