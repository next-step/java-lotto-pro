package lotto.model;

import lotto.exception.InvalidInputException;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.common.Constants.GET_NUMBER_COUNT;

public class WinningNumbers {

    private static final String LIST_SEPARATOR = ",";
    private static final String INVALID_NUMBER_COUNT_MESSAGE= "당첨번호 %s개를 입력해야 합니다.";
    private static final String INVALID_DUPLICATE_MESSAGE= "당첨번호를 중복입력을 할 수 없습니다.";

    private List<WinningNumber> values;

    public WinningNumbers(String inputRawValues) {
        String[] inputValues = inputRawValues.replace(" ", "").split(LIST_SEPARATOR);
        validateSize(inputValues);
        this.values = Arrays.stream(inputValues)
                .map(WinningNumber::new)
                .collect(Collectors.toList());
        validateDuplicated();
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

    public List<WinningNumber> getValues() {
        return values;
    }

}
