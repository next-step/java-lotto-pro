package calculator;

import static calculator.ErrorMessage.*;

public class Converter {

    private static final String NUMBER_REGEX = "[+-]?\\d*(\\.\\d+)?";

    public static int[] convert(String[] tokens) {
        int[] result = new int[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            validateToken(tokens[i]);
            int number = Integer.parseInt(tokens[i]);
            validateNumber(number);
            result[i] = number;
        }
        return result;
    }

    private static void validateToken(String token) {
        if (!token.matches(NUMBER_REGEX)) {
            throw new RuntimeException(TOKEN_ERROR.getMessage());
        }
    }

    private static void validateNumber(int number) {
        if (number < 0) {
            throw new RuntimeException(NUMBER_ERROR.getMessage());
        }
    }
}
