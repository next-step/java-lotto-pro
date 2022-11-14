package step5.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    private final List<LottoNo> numbers;

    public Lotto(List<LottoNo> numbers) {
        validateWinningNumbers(numbers);
        this.numbers = sortedNumbers(numbers);
    }

    private void validateWinningNumbers(List<LottoNo> lottoNos) {
        validateNull(lottoNos);
        validateSizeSixNumbers(lottoNos);
        validateDuplicatedNumbers(lottoNos);
    }

    private void validateDuplicatedNumbers(List<LottoNo> lottoNos) {
        if (isDuplicated(lottoNos)) {
            throw new RuntimeException("증복된 숫자가 있습니다.");
        }
    }

    private void validateSizeSixNumbers(List<LottoNo> lottoNos) {
        if (lottoNos.size() != 6) {
            throw new RuntimeException("6자리 수만 입력받을수있습니다.");
        }
    }

    private void validateNull(List<LottoNo> lottoNos) {
        if (lottoNos == null) {
            throw new RuntimeException("행운의번호가 널입니다.");
        }
    }

    private boolean isDuplicated(List<LottoNo> lottoNos) {
        Set<LottoNo> uniqueNumbers = new HashSet<>(lottoNos);
        return uniqueNumbers.size() != lottoNos.size();
    }

    private List<LottoNo> sortedNumbers(List<LottoNo> numbers) {
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

    public boolean contains(LottoNo bonusNumber) {
        return numbers.contains(bonusNumber);
    }
}
