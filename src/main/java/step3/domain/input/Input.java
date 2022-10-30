package step3.domain.input;

import java.util.Scanner;

import static step3.type.ErrorMessageType.INPUT_NOT_ALLOW_BLANK;

public interface Input<T> {
    Scanner scanner = new Scanner(System.in);

    T create(String input);

    default void validateBlank(String input) {
        if (isNull(input) || isEmpty(input)) {
            throw new IllegalArgumentException(INPUT_NOT_ALLOW_BLANK.getMessage());
        }
    }

    static boolean isEmpty(String input) {
        return input.isEmpty();
    }

    static boolean isNull(String input) {
        return input == null;
    }
}
