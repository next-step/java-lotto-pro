package lotto.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Stream;
import lotto.constant.LottoConstant;

public class LottoInputValidator {

    private static final String POSITIVE_NUMBER_REGEX = "^[0-9]+$";
    private static final String LOTTO_NUMBER_REGEX = "^[1-9]$|[1-3][0-9]|4[0-5]$";

    private LottoInputValidator() {
    }

    public static boolean validatePurchasePrice(String number) {
        return validateNonNegativeNumber(number) &&
                validateGreaterOrEqualThanPriceOfOneLotto(number);
    }

    public static boolean validateWinningNumbers(String strNumbers) {
        String[] splitNumbers = strNumbers.split(LottoConstant.COMMA_DELIMITER_REGEX);
        return validateNumbersInRanges(splitNumbers) &&
                validateNonDuplicatedNumbers(splitNumbers) &&
                validateSixNumbers(splitNumbers);
    }

    private static boolean validateGreaterOrEqualThanPriceOfOneLotto(String number) {
        return Double.parseDouble(number) >= LottoConstant.PRICE_OF_ONE_LOTTO;
    }

    private static boolean validateNonNegativeNumber(String number) {
        return number.matches(POSITIVE_NUMBER_REGEX);
    }

    private static boolean validateNumbersInRanges(String[] numbers) {
        return Stream.of(numbers).allMatch(number -> number.trim().matches(LOTTO_NUMBER_REGEX));
    }

    private static boolean validateNonDuplicatedNumbers(String[] numbers) {
        return new HashSet<>(Arrays.asList(numbers)).size() == numbers.length;
    }

    private static boolean validateSixNumbers(String[] numbers) {
        return numbers.length == LottoConstant.LOTTO_NUMBER_COUNT;
    }
}
