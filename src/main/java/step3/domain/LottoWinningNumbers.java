package step3.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LottoWinningNumbers {
    private static final String WINNING_NUMBER_FORMAT_ERROR_MESSAGE = "당첨번호는 1이상 45이하의 정수만 가능합니다.";
    private static final String WINNING_NUMBER_LENGTH_ERROR_MESSAGE = "당첨번호는 6자리의 숫자여야만 합니다.";
    private static final String WINNING_NUMBER_DUPLICATE_ERROR_MESSAGE = "당첨번호는 중복이 불가능합니다.";

    private final List<Integer> winningNumbers;

    public LottoWinningNumbers(final String winningNumbers) {
        final String[] splittedWinningNumbers = winningNumbers.split(",");
        checkWinningNumbersSize(splittedWinningNumbers);
        this.winningNumbers = createWinningNumbers(splittedWinningNumbers);
    }

    private void checkWinningNumbersSize(final String[] splittedWinningNumbers) {
        if (splittedWinningNumbers.length < Lotto.LOTTO_SIZE) {
            throw new IllegalArgumentException(WINNING_NUMBER_LENGTH_ERROR_MESSAGE);
        }
    }

    private List<Integer> createWinningNumbers(final String[] splittedWinningNumbers) {
        final List<Integer> winningNumbers = new ArrayList<>();
        for (final String winningNumber : splittedWinningNumbers) {
            final Integer number = parseInt(winningNumber.trim());
            checkNumberRangeOneToFourtyFive(number);
            winningNumbers.add(number);
        }
        checkWinningNumbersDuplicated(winningNumbers);
        return winningNumbers;
    }

    private Integer parseInt(final String winningNumber) {
        Integer number;
        try {
            number = Integer.parseInt(winningNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(WINNING_NUMBER_FORMAT_ERROR_MESSAGE);
        }
        return number;
    }

    private void checkNumberRangeOneToFourtyFive(final Integer number) {
        if (number < Lotto.LOTTO_MIN_NUMBER) {
            throw new IllegalArgumentException(WINNING_NUMBER_FORMAT_ERROR_MESSAGE);
        }
        if (number > Lotto.LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException(WINNING_NUMBER_FORMAT_ERROR_MESSAGE);
        }
    }

    private void checkWinningNumbersDuplicated(final List<Integer> winningNumbers) {
        int distinctCount = new HashSet<>(winningNumbers).size();
        if (distinctCount != winningNumbers.size()) {
            throw new IllegalArgumentException(WINNING_NUMBER_DUPLICATE_ERROR_MESSAGE);
        }
    }

    public int size() {
        return winningNumbers.size();
    }

    public Integer get(final int index) {
        return winningNumbers.get(index);
    }
}
