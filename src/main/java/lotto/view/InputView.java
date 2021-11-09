package lotto.view;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

public class InputView {

    private static final String INVALID_WINNING_NUMBER = "로또 번호를 정확하게 입력해주세요.";
    private static final Scanner SCAN = new Scanner(System.in);
    private static final String SEPARATOR_COMMA = ",";

    private InputView() {
    }

    public static int inputPurchaseAmount() {
        return Integer.parseInt(SCAN.nextLine());
    }

    public static List<Integer> inputWinningNumbers() {
        return splitWinningNumbers(SCAN.nextLine());
    }

    public static int inputBonusNumber() {
        return Integer.parseInt(SCAN.nextLine());
    }

    private static List<Integer> splitWinningNumbers(String inputWinningNumbers) {
        validateNullOrEmpty(inputWinningNumbers);
        return stream(inputWinningNumbers.split(SEPARATOR_COMMA))
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
    }

    private static void validateNullOrEmpty(String inputWinningNumbers) {
        if (inputWinningNumbers == null || inputWinningNumbers.trim().isEmpty()) {
            throw new IllegalArgumentException(INVALID_WINNING_NUMBER);
        }
    }

}
