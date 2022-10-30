package lotto.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.util.LottoNumberGenerator.MAX_LOTTO_NUMBER;
import static lotto.util.LottoNumberGenerator.MIN_LOTTO_NUMBER;

public class InputValidator {
    private static final String ERROR_MESSAGE_INVALID_NUMBER = "[ERROR] 유효하지 않은 구매금액입니다.";
    private static final String ERROR_MESSAGE_INVALID_RANGE_NUMBER = "[ERROR] 유효하지 않은 당첨 번호(입력범위:1~45)";
    private static final String ERROR_MESSAGE_DUPLICATED_NUMBER = "[ERROR] 유효하지 않은 당첨 번호(중복)";
    private static final String ERROR_MESSAGE_INVALID_SIZE = "[ERROR] 유효하지 않은 당첨 번호(6개 숫자 필요)";
    private static final String REGEX_DIGIT = "\\d+";
    private static final int VALID_LOTTO_NUMBER_SIZE = 6;

    public static void validateNumberFormat(String input) {
        if (!input.matches(REGEX_DIGIT)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_INVALID_NUMBER);
        }
    }

    public static void validateDuplicateLottoNumber(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (numbers.size() != uniqueNumbers.size()) {
            throw new IllegalArgumentException(ERROR_MESSAGE_DUPLICATED_NUMBER);
        }
    }

    public static void validateLottoNumberRange(int number) {
        if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(ERROR_MESSAGE_INVALID_RANGE_NUMBER);
        }
    }

    public static void validateLottoNumberCount(int lottoNumberCount) {
        if (lottoNumberCount != VALID_LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(ERROR_MESSAGE_INVALID_SIZE);
        }
    }
}