package lotto.view;

import java.util.Scanner;

import static java.util.Arrays.stream;

public class InputView {
    private static final String INVALID_PRIZE_NUMBER = "당첨 번호를 정확하게 입력해주세요.";
    private static final Scanner SCAN = new Scanner(System.in);

    private InputView() {
    }

    public static int inputPurchaseAmount() {
        return Integer.parseInt(SCAN.nextLine());
    }

    public static String[] inputPrizeNumbers() {
        return splitPrizeNumbers(SCAN.nextLine());
    }

    private static String[] splitPrizeNumbers(String inputPrizeNumbers) {
        validateNullOrEmpty(inputPrizeNumbers);
        return stream(inputPrizeNumbers.split(","))
                .map(String::trim)
                .toArray(String[]::new);
    }

    private static void validateNullOrEmpty(String inputPrizeNumbers) {
        if (inputPrizeNumbers == null || inputPrizeNumbers.trim().isEmpty()) {
            throw new IllegalArgumentException(INVALID_PRIZE_NUMBER);
        }
    }

}
