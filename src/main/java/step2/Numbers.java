package step2;

import java.util.Arrays;

public class Numbers {
    private final int[] numbers;
    private static final int MINUS_STANDARD = 0;
    private static final String MINUS_ERROR_MESSAGE = "cannot enter minus number.";
    private static final String NOT_A_NUMBER_ERROR_MESSAGE = "cannot enter not a number.";

    Numbers(final String[] numbers) {
        this.numbers = Arrays.stream(numbers)
                .mapToInt(number -> {
                    final int parsedNumber = parseStringToInt(number);
                    checkNumberIsMinus(parsedNumber);
                    return parsedNumber;
                })
                .toArray();
    }

    public int getTotal() {
        return Arrays.stream(this.numbers).sum();
    }

    private void checkNumberIsMinus(final int parsedNumber) {
        if (parsedNumber < MINUS_STANDARD) {
            throw new IllegalArgumentException(MINUS_ERROR_MESSAGE);
        }
    }

    private int parseStringToInt(final String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(NOT_A_NUMBER_ERROR_MESSAGE);
        }
    }
}
