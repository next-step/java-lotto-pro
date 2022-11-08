package step4.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    private final List<LottoNumber> numbers;

    public Lotto(List<LottoNumber> numbers) {
        validateWinningNumbers(numbers);
        this.numbers = sortedNumbers(numbers);
    }

    private void validateWinningNumbers(List<LottoNumber> winningNumbers) {
        validateNull(winningNumbers);
        validateSizeSixNumbers(winningNumbers);
        validateDuplicatedNumbers(winningNumbers);
    }

    private void validateDuplicatedNumbers(List<LottoNumber> winningNumbers) {
        if (isDuplicated(winningNumbers)) {
            throw new RuntimeException("증복된 숫자가 있습니다.");
        }
    }

    private void validateSizeSixNumbers(List<LottoNumber> winningNumbers) {
        if (winningNumbers.size() != 6) {
            throw new RuntimeException("6자리 수만 입력받을수있습니다.");
        }
    }

    private void validateNull(List<LottoNumber> winningNumbers) {
        if (winningNumbers == null) {
            throw new RuntimeException("행운의번호가 널입니다.");
        }
    }

    private boolean isDuplicated(List<LottoNumber> winningNumbers) {
        Set<LottoNumber> uniqueNumbers = new HashSet<>(winningNumbers);
        return uniqueNumbers.size() != winningNumbers.size();
    }

    private List<LottoNumber> sortedNumbers(List<LottoNumber> numbers) {
        return numbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public int getMatchedCount(Lotto otherLotto) {
        return (int) numbers.stream()
                .filter(otherLotto.numbers::contains)
                .count();
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    public boolean contains(LottoNumber bonusNumber) {
        return numbers.contains(bonusNumber);
    }
}
