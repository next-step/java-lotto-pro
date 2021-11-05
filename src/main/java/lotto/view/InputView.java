package lotto.view;

import java.util.Scanner;

import static java.util.Arrays.stream;

public class InputView {
    private static final String INVALID_WINNING_NUMBER = "당첨 번호를 정확하게 입력해주세요.";
    private static final Scanner SCAN = new Scanner(System.in);

    private InputView() {
    }

    public static int inputPurchaseAmount() {
        return Integer.parseInt(SCAN.nextLine());
    }

    public static String[] inputWinningNumbers() {
        return splitWinningNumbers(SCAN.nextLine());
    }

    private static String[] splitWinningNumbers(String inputWinningNumbers) {
        validateNullOrEmpty(inputWinningNumbers);
        return stream(inputWinningNumbers.split(","))
                .map(String::trim)
                .toArray(String[]::new);
    }

    private static void validateNullOrEmpty(String inputWinningNumbers) {
        if (inputWinningNumbers == null || inputWinningNumbers.trim().isEmpty()) {
            throw new IllegalArgumentException(INVALID_WINNING_NUMBER);
        }
    }

}
