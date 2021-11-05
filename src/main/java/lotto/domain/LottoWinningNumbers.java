package lotto.domain;

import java.util.List;

import static java.util.Arrays.stream;
import static java.util.Comparator.naturalOrder;
import static java.util.stream.Collectors.toList;

public class LottoWinningNumbers {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int LOTTO_NUMBER_SIZE = 6;
    private static final String INVALID_NUMBER = "당첨번호는 중복이되면 안됩니다.";
    private static final String INVALID_NUMBER_SIZE = "당첨번호는 6자리여야 합니다.";
    private static final String INVALID_BETWEEN_MIN_AND_MAX = "당첨 번호는 1 ~ 45 중에서 골라주세요.";
    private final List<Integer> winningNumbers;

    public LottoWinningNumbers(String[] splitWinningNumbers) {
        validateDuplicate(splitWinningNumbers);
        validateSize(splitWinningNumbers);
        validateBetweenMinAndMax(splitWinningNumbers);
        winningNumbers = parser(splitWinningNumbers);
        winningNumbers.sort(naturalOrder());
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    private void validateBetweenMinAndMax(String[] splitWinningNumbers) {
        if (!stream(splitWinningNumbers)
                .mapToInt(Integer::parseInt)
                .allMatch(LottoWinningNumbers::isBetweenMinAndMax)) {
            throw new IllegalArgumentException(INVALID_BETWEEN_MIN_AND_MAX);
        }
    }

    private void validateDuplicate(String[] splitWinningNumbers) {
        if (stream(splitWinningNumbers)
                .distinct()
                .count() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(INVALID_NUMBER);
        }
    }

    private void validateSize(String[] splitWinningNumbers) {
        if (splitWinningNumbers.length != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(INVALID_NUMBER_SIZE);
        }
    }

    private static boolean isBetweenMinAndMax(int prizeNumber) {
        return (prizeNumber >= MIN_LOTTO_NUMBER) && (prizeNumber <= MAX_LOTTO_NUMBER);
    }

    private List<Integer> parser(String[] splitWinningNumbers) {
        return stream(splitWinningNumbers)
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(toList());
    }
}
