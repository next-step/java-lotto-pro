package lotto.model.winning.numbers;

import lotto.constant.numbers.LottoConstant;
import lotto.constant.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class WinningNumbers {
    private final List<WinningNumberEach> numbers;

    public WinningNumbers(String input) {
        if (StringUtils.isNullOrEmpty(input)) {
            throw new IllegalArgumentException("올바르지 않은 값을 당첨 번호로 입력했습니다.");
        }
        final String trimmedInput = input.trim();
        if (isCommaPrefixOrPostfix(trimmedInput)) {
            throw new IllegalArgumentException("쉽표가 맨 앞 또는 맨 뒤에 올 수 없습니다.");
        }
        final String[] tokens = splitBLottoDelimiter(trimmedInput);
        numbers = convertStringToWinningNumberEach(tokens);
    }

    public WinningNumbers(List<WinningNumberEach> numbers) {
        this.numbers = numbers;
    }

    private boolean isCommaPrefixOrPostfix(String input) {
        return input.charAt(0) == ',' || input.charAt(input.length() - 1) == ',';
    }

    private String[] splitBLottoDelimiter(String input) {
        return input.split(LottoConstant.LOTTO_NUMBERS_STRING_DELIMITER_REGEX);
    }

    private List<WinningNumberEach> convertStringToWinningNumberEach(String[] tokens) {
        List<WinningNumberEach> numbers = new ArrayList<>(tokens.length);
        for (String token : tokens) {
            numbers.add(new WinningNumberEach(token));
        }
        return numbers;
    }

    public List<Integer> primitiveNumbers() {
        List<Integer> intWinningNumbers = new ArrayList<>(numbers.size());
        for (WinningNumberEach winningNumberEach : numbers) {
            intWinningNumbers.add(winningNumberEach.primitive());
        }
        return intWinningNumbers;
    }
}
