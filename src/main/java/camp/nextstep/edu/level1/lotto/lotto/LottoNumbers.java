package camp.nextstep.edu.level1.lotto.lotto;

import java.util.*;
import java.util.stream.Collectors;

public class LottoNumbers {
    private static final int LOTTO_START_NUMBER = 1;
    private static final int LOTTO_END_NUMBER = 45;
    private static final int LOTTO_RANGE = 6;
    private static final String PRINT_JOIN_DELIMITER = ", ";
    private static final String TO_STRING_PREFIX = "[";
    private static final String TO_STRING_SUFFIX = "]";

    private final Set<LottoNumber> lottoNumbers = new HashSet<>();

    public LottoNumbers(Collection<Integer> numbers) {
        checkLottoNumbers(numbers);

        addAll(numbers);
    }

    public long matchedCountByWinnerNumbers(LottoNumbers winnerNumbers) {
        return winnerNumbers.lottoNumbers.stream()
                .filter(this::hasContainLottoNumber)
                .count();
    }

    public boolean isContainLottoNumber(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    private void addAll(Collection<Integer> numbers) {
        for (Integer number : numbers) {
            this.lottoNumbers.add(new LottoNumber(number));
        }
    }

    private boolean hasContainLottoNumber(LottoNumber value) {
        return this.lottoNumbers.stream().anyMatch(lottoNumber -> lottoNumber.hasSameValue(value));
    }

    private void checkLottoNumbers(Collection<Integer> numbers) {
        Set<Integer> convertedCollectionToSet = new HashSet<>(numbers);
        if (convertedCollectionToSet.size() != LOTTO_RANGE) {
            throw new IllegalArgumentException("로또는 6 자리의 숫자만 허용됩니다.");
        }

        for (Integer number : numbers) {
            checkContainsDisallowedNumbers(number);
        }
    }

    private void checkContainsDisallowedNumbers(Integer number) {
        if (number < LOTTO_START_NUMBER || number > LOTTO_END_NUMBER) {
            throw new IllegalArgumentException("로또 번호는 1 에서 45 사이의 값만 허용합니다.");
        }
    }

    @Override
    public String toString() {
        return TO_STRING_PREFIX + this.lottoNumbers.stream()
                .map(LottoNumber::toString)
                .collect(Collectors.joining(PRINT_JOIN_DELIMITER)) + TO_STRING_SUFFIX;
    }
}
