/*
 * Validate.java
 * v0.1
 * 2022.10.30
 */
package lotto;

import static lotto.Constant.DELIMITER;
import static lotto.Constant.ERROR_INPUT_EMPTY;
import static lotto.Constant.ERROR_INPUT_SIX_NUMBER;
import static lotto.Constant.ERROR_LOTTO_COST;
import static lotto.Constant.ERROR_NUMBER_RANGE;
import static lotto.Constant.ERROR_ONLY_NUMBER;
import static lotto.Constant.LOTTO_END_NUMBER;
import static lotto.Constant.LOTTO_NUMBER_SIZE;
import static lotto.Constant.LOTTO_PRICE;
import static lotto.Constant.LOTTO_START_NUMBER;
import static lotto.Constant.NULL;
import static lotto.Constant.REGEX_ONLY_NUMBER;

import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class Validate {
    static void validateNull(String input) {
        if (input.equals(NULL)) {
            throw new IllegalArgumentException(ERROR_INPUT_EMPTY);
        }
    }

    static void validatePay(String input) {
        if (Integer.parseInt(input) < LOTTO_PRICE) {
            throw new IllegalArgumentException(ERROR_LOTTO_COST);
        }
    }

    static void validateOnlyNumber(String input) {
        if (input.equals(NULL)) {
            throw new IllegalArgumentException(ERROR_ONLY_NUMBER);
        }
        if (!Pattern.matches(REGEX_ONLY_NUMBER, input)) {
            throw new IllegalArgumentException(ERROR_ONLY_NUMBER);
        }
    }

    static void validateWinningNumberRange(String input) {
        StringTokenizer token = new StringTokenizer(input, DELIMITER);
        while (token.hasMoreTokens()) {
            validateNumberRange(Integer.parseInt(token.nextToken()));
        }
    }

    static void validateNumberRange(int number) {
        if (number < LOTTO_START_NUMBER || number > LOTTO_END_NUMBER) {
            throw new IllegalArgumentException(ERROR_NUMBER_RANGE);
        }
    }

    static void validateWinningNumber(String input) {
        StringTokenizer token = new StringTokenizer(input, DELIMITER);
        while (token.hasMoreTokens()) {
            validateOnlyNumber(token.nextToken());
        }
    }

    static void validateWinningNumberCount(String input) {
        if (new StringTokenizer(input, DELIMITER).countTokens() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(ERROR_INPUT_SIX_NUMBER);
        }
    }
}
