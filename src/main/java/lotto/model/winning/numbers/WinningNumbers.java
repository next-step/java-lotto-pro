package lotto.model.winning.numbers;

import lotto.constant.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 당첨 번호 6 개를 저장하는 객체이다.
 */
public class WinningNumbers {
    private static final String DELIMITER_REGEX = ",";
    private final List<WinningNumberEach> numbers;

    public WinningNumbers(String input) {
        if (StringUtils.isNullOrEmpty(input)) {
            throw new IllegalArgumentException("올바르지 않은 값을 당첨 번호로 입력했습니다.");
        }
        final String trimmedInput = input.trim();
        if (isCommaPrefixOrPostfix(trimmedInput)) {
            throw new IllegalArgumentException("쉽표가 맨 앞 또는 맨 뒤에 올 수 없습니다.");
        }
        final String[] tokens = splitByComma(trimmedInput);
        numbers = convertStringToWinningNumberEach(tokens);
    }

    private boolean isCommaPrefixOrPostfix(String input) {
        return input.charAt(0) == ',' || input.charAt(input.length() - 1) == ',';
    }

    private String[] splitByComma(String input) {
        return input.split(DELIMITER_REGEX);
    }

    private List<WinningNumberEach> convertStringToWinningNumberEach(String[] tokens) {
        List<WinningNumberEach> numbers = new ArrayList<>(tokens.length);
        for (String token : tokens) {
            numbers.add(new WinningNumberEach(token));
        }
        return numbers;
    }
}
