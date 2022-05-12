package step2;

import java.util.Arrays;

public class Numbers {
    final int[] numbers;

    Numbers(final String[] numbers) {
        this.numbers = Arrays.stream(numbers)
                .mapToInt(number -> {
                    final int parsedNumber = parseStringToInt(number);
                    checkNumberIsMinus(parsedNumber);
                    return parsedNumber;
                })
                .toArray();
    }

    public int total() {
        return Arrays.stream(this.numbers).sum();
    }

    private void checkNumberIsMinus(final int parsedNumber) {
        if (parsedNumber < 0) {
            throw new RuntimeException("cannot enter minus number.");
        }
    }

    private int parseStringToInt(final String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new RuntimeException("cannot enter not a number.");
        }
    }
}
