package lotto.model;

import lotto.exception.InvalidInputException;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.common.Constants.*;

public class WinningNumbers {

    private static final String LIST_SEPARATOR = ",";
    private static final String INVALID_NUMBER_COUNT_MESSAGE= "당첨번호 %s개를 입력해야 합니다.";
    private static final String INVALID_DUPLICATE_MESSAGE= "당첨번호를 중복입력을 할 수 없습니다.";
    private static final String INVALID_WINNING_NUMBER_MESSAGE= "%s-%s 사이의 숫자만 입력할 수 있습니다.";

    private List<Integer> values;

    public WinningNumbers(String inputRawValues) {
        String[] inputValues = inputRawValues.replace(" ", "").split(LIST_SEPARATOR);
        validateSize(inputValues);
        this.values = Arrays.stream(inputValues)
                .map(Integer::valueOf)
                .collect(Collectors.toList());
        validateDuplicated();
        this.values.forEach(value -> validateWinningNumber(value));
    }

    /**
     * 입력값 길이 유효성검사
     * 입력값의 길이가 GET_NUMBER_COUNT와 다르면 예외처리를 합니다.
     *
     * @param inputRawValues
     */
    private void validateSize(String[] inputRawValues) {
        if (inputRawValues.length != GET_NUMBER_COUNT) {
            throw new InvalidInputException(String.format(INVALID_NUMBER_COUNT_MESSAGE, GET_NUMBER_COUNT));
        }
    }

    /**
     * 입력값 중복 유효성검사
     * 입력값이 중복되면 예외처리를 합니다.
     */
    private void validateDuplicated() {
        long duplicatedCount = this.values
                .stream()
                .filter(value -> Collections.frequency(this.values, value) > 1)
                .count();
        if (duplicatedCount > 0) {
            throw new InvalidInputException(String.format(INVALID_DUPLICATE_MESSAGE));
        }
    }

    /**
     * 입력값 유효성검사
     * 입력값이 MIN_RANGE_VALUE와 MAX_RANGE_VALUE의 사이에 포함되지 않으면 예외처리를 합니다.
     *
     * @param number
     */
    private void validateWinningNumber(int number) {
        if (number < MIN_RANGE_VALUE || number > MAX_RANGE_VALUE) {
            throw new InvalidInputException(String.format(INVALID_WINNING_NUMBER_MESSAGE, MIN_RANGE_VALUE, MAX_RANGE_VALUE));
        }
    }

    public List<Integer> getValues() {
        return values;
    }

}
