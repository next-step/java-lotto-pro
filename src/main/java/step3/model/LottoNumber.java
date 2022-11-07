package step3.model;

import step3.constant.StringConstant;
import step3.service.LottoGenerator;

import java.util.*;
import java.util.stream.Collectors;

public class LottoNumber {
    private final List<Integer> numbers;

    public LottoNumber(List<Integer> numbers) {
        validateWinningNumbers(numbers);
        this.numbers = sortedNumbers(numbers);
    }

    private List<Integer> sortedNumbers(List<Integer> numbers) {
        return numbers.stream().sorted().collect(Collectors.toList());
    }

    private void validateWinningNumbers(List<Integer> winningNumbers) {
        validateNull(winningNumbers);
        validateSizeSixNumbers(winningNumbers);
        validateDuplicatedNumbers(winningNumbers);
        isExceedRange(winningNumbers);
    }

    private void validateDuplicatedNumbers(List<Integer> winningNumbers) {
        if (isDuplicated(winningNumbers)) {
            throw new RuntimeException("증복된 숫자가 있습니다.");
        }
    }

    private void validateSizeSixNumbers(List<Integer> winningNumbers) {
        if (winningNumbers.size() != 6) {
            throw new RuntimeException("6자리 수만 입력받을수있습니다.");
        }
    }

    private void validateNull(List<Integer> winningNumbers) {
        if (winningNumbers == null) {
            throw new RuntimeException("행운의번호가 널입니다.");
        }
    }

    private void isExceedRange(List<Integer> winningNumbers) {
        for (int number : winningNumbers) {
            isNotBetween(number);
        }
    }

    private void isNotBetween(int number) {
        if (number < LottoGenerator.LOTTO_START_NUMBER || number > LottoGenerator.LOTTO_END_NUMBER) {
            throw new RuntimeException("로또범위의 숫자가 아닙니다.");
        }
    }

    private boolean isDuplicated(List<Integer> winningNumbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(winningNumbers);

        return uniqueNumbers.size() != winningNumbers.size();
    }

    @Override
    public String toString() {
        return numbers.stream()
                .map(Object::toString)
                .collect(Collectors.joining(StringConstant.COMMA));
    }

    public boolean contains(int number) {
        return this.numbers.contains(number);
    }

    public int getMatchedCount(LottoNumber otherLottoNumber) {
        return (int) this.numbers.stream().filter(otherLottoNumber.numbers::contains).count();
    }
}
