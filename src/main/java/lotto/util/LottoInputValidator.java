package lotto.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import lotto.constant.LottoConstant;

public class LottoInputValidator {

    public static final String POSITIVE_NUMBER_REGEX = "^[0-9]+$";

    private LottoInputValidator() {
    }

    public static boolean validateNonNegativeNumber(String number) {
        return number.matches(POSITIVE_NUMBER_REGEX);
    }

    public static boolean validateWinningNumbers(String strNumbers) {
        String[] splitNumbers = strNumbers.split(LottoConstant.COMMA_DELIMITER_REGEX);
        List<Integer> intNumbers = StringToIntegerConvertor.convertNumbers(splitNumbers);
        return validateNonNegativeNumbers(splitNumbers) &&
                validateNonDuplicatedSixNumbers(intNumbers) &&
                validateNumberRange(intNumbers);
    }

    private static boolean validateNonNegativeNumbers(String[] splitNumbers) {
        return Arrays.stream(splitNumbers).allMatch(LottoInputValidator::validateNonNegativeNumber);
    }

    private static boolean validateNonDuplicatedSixNumbers(List<Integer> numbers) {
        return new HashSet<>(numbers).size() == LottoConstant.LOTTO_NUMBER_COUNT;
    }

    private static boolean validateNumberRange(List<Integer> numbers) {
        numbers.sort(Integer::compareTo);
        return numbers.get(0) >= LottoConstant.MIN_LOTTO_NUMBER &&
                numbers.get(numbers.size() - 1) <= LottoConstant.MAX_LOTTO_NUMBER;
    }
}
