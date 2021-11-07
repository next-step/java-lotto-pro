package lotto.utils;

import java.util.Arrays;

import lotto.domain.LottoNumbers;
import lotto.domain.Money;

public class ValidationUtils {
    private static final String REGEX_NUMBER = "[0-9]+";

    private ValidationUtils() {
    }

    public static boolean isNumber(String number) {
        return number.matches(REGEX_NUMBER);
    }

    public static boolean upperThanMinPrice(String number) {
        return Integer.parseInt(number) >= Money.LOTTO_BUY_PRICE;
    }

    public static boolean isCorrectQuantity(String[] numbers) {
        return numbers.length == LottoNumbers.LOTTO_NUMBER_QUANTITY;
    }

    public static boolean isAllNumber(String[] numbers) {
        return Arrays.stream(numbers).allMatch(number -> isNumber(number));
    }

    public static boolean checkDuplicatedNumber(String[] numbers) {
        return Arrays.stream(numbers).distinct().count() != numbers.length;
    }

    public static boolean checkNumberRange(String[] numbers) {
        return Arrays.stream(numbers)
                .allMatch(number -> isBetweenRange(Integer.parseInt(number)));
    }
    
    private static boolean isBetweenRange(int number) {
        return number >= LottoNumbers.LOTTO_MIN_NUMBER && number <= LottoNumbers.LOTTO_MAX_NUMBER;
    }

}
