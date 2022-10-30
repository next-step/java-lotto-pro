package lotto;

import static lotto.Constant.LOTTO_PRICE;
import static lotto.Constant.REGEX_ONLY_NUMBER;

import java.util.regex.Pattern;

class Validate {
    static int validatePay(int input) {
        if (input < LOTTO_PRICE) {
            throw new IllegalArgumentException("로또 1장의 구입 가격은 " + LOTTO_PRICE + "원 입니다.");
        }
        return input;
    }

    static int validateInput(String input) {
        if (!Pattern.matches(REGEX_ONLY_NUMBER, input)) {
            throw new IllegalArgumentException("숫자만 입력할 수 있습니다.");
        }
        return Integer.parseInt(input);
    }

    static int validateNumberRange(int number) {
        if (number <= 0 || number >= 46) {
            throw new IllegalArgumentException("숫자는 1 ~ 45까지 입력할 수 있습니다.");
        }
        return number;
    }
}
