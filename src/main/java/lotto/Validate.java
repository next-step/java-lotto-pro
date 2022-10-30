package lotto;

import static lotto.Constant.ERROR_LOTTO_COST;
import static lotto.Constant.ERROR_NUMBER_RANGE;
import static lotto.Constant.ERROR_ONLY_NUMBER;
import static lotto.Constant.LOTTO_PRICE;
import static lotto.Constant.REGEX_ONLY_NUMBER;

import java.util.regex.Pattern;

class Validate {
    static int validatePay(int input) {
        if (input < LOTTO_PRICE) {
            throw new IllegalArgumentException(ERROR_LOTTO_COST);
        }
        return input;
    }

    static int validateInput(String input) {
        if (!Pattern.matches(REGEX_ONLY_NUMBER, input)) {
            throw new IllegalArgumentException(ERROR_ONLY_NUMBER);
        }
        return Integer.parseInt(input);
    }

    static int validateNumberRange(int number) {
        if (number <= 0 || number >= 46) {
            throw new IllegalArgumentException(ERROR_NUMBER_RANGE);
        }
        return number;
    }
}
