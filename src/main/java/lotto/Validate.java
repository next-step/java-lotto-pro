/*
 * Validate.java
 * v0.1
 * 2022.10.30
 */
package lotto;

import static lotto.Constant.DELIMITER;
import static lotto.Constant.ERROR_BONUS_NUMBER_DUPLICATED;
import static lotto.Constant.ERROR_EMPTY_PAY_MONEY;
import static lotto.Constant.ERROR_EXCEED_PURCHASABLE_COUNT;
import static lotto.Constant.ERROR_INPUT_SIX_NUMBER;
import static lotto.Constant.ERROR_LOTTO_COST;
import static lotto.Constant.ERROR_LOTTO_NUMBER_DUPLICATED;
import static lotto.Constant.ERROR_NUMBER_OUT_OF_RANGE;
import static lotto.Constant.ERROR_ONLY_NUMBER;
import static lotto.Constant.LOTTO_END_NUMBER;
import static lotto.Constant.LOTTO_NUMBER_SIZE;
import static lotto.Constant.LOTTO_PRICE;
import static lotto.Constant.LOTTO_START_NUMBER;
import static lotto.Constant.NULL;
import static lotto.Constant.REGEX_ONLY_NUMBER;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class Validate {
    static void isPurchasable(String payment) {
        if (Integer.parseInt(payment) < LOTTO_PRICE) {
            throw new IllegalArgumentException(ERROR_LOTTO_COST);
        }
    }

    static void isPurchasable(int balance, Quantity quantity) {
        if (balance < (quantity.getQuantity() * LOTTO_PRICE)) {
            throw new IllegalArgumentException(ERROR_EXCEED_PURCHASABLE_COUNT);
        }
    }

    static void isEmpty(String input) {
        if (Objects.equals(input, NULL)) {
            throw new IllegalArgumentException(ERROR_EMPTY_PAY_MONEY);
        }
        if (input.isEmpty()) {
            throw new IllegalArgumentException(ERROR_EMPTY_PAY_MONEY);
        }
    }

    static void isNumber(String input) {
        if (!Pattern.matches(REGEX_ONLY_NUMBER, input)) {
            throw new IllegalArgumentException(ERROR_ONLY_NUMBER);
        }
    }

    static void isOutOfBound(int number) {
        if (number < LOTTO_START_NUMBER || number > LOTTO_END_NUMBER) {
            throw new IllegalArgumentException(ERROR_NUMBER_OUT_OF_RANGE);
        }
    }

    static void isSixNumbers(List<Integer> sixNumbers) {
        if (sixNumbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(ERROR_INPUT_SIX_NUMBER);
        }
    }

    static void isDuplicate(String bonus, Lotto winningNumber) {
        if (winningNumber.contains(LottoNumber.from(bonus))) {
            throw new IllegalArgumentException(ERROR_BONUS_NUMBER_DUPLICATED);
        }
    }

    static void isDuplicate(String input) {
        if (inputToSet(input) < LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(ERROR_LOTTO_NUMBER_DUPLICATED);
        }
    }

    private static int inputToSet(String input) {
        Set<String> checkSet = new HashSet<>();
        StringTokenizer token = new StringTokenizer(input, DELIMITER);
        while (token.hasMoreTokens()) {
            checkSet.add(token.nextToken());
        }
        return checkSet.size();
    }
}
