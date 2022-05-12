package camp.nextstep.edu.level1.lotto.lotto;

import camp.nextstep.edu.until.RandomGenerator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumbers {
    private final static int LOTTO_START_NUMBER = 1;
    private final static int LOTTO_END_NUMBER = 45;
    private final static int LOTTO_RANGE = 6;
    private final static String PRINT_JOIN_DELIMITER = ", ";
    private final static String TO_STRING_PREFIX = "[";
    private final static String TO_STRING_SUFFIX = "]";

    private final List<LottoNumber> value = new ArrayList<>();

    public LottoNumbers() {
        this(RandomGenerator.createNonDuplicatedIntegerSet(LOTTO_START_NUMBER, LOTTO_END_NUMBER, LOTTO_RANGE));
    }

    public LottoNumbers(Collection<Integer> numbers) {
        checkLottoNumbers(numbers);

        addAll(numbers);
    }

    public long matchedCountByWinnerNumbers(LottoNumbers winnerNumbers) {
        return winnerNumbers.value.stream().filter(this::hasContainLottoNumber).count();
    }

    private void addAll(Collection<Integer> numbers) {
        for (Integer number : numbers) {
            this.value.add(new LottoNumber(number));
        }
    }

    private boolean hasContainLottoNumber(LottoNumber value) {
        return this.value.stream().anyMatch(lottoNumber -> lottoNumber.hasSameValue(value));
    }

    private void checkLottoNumbers(Collection<Integer> numbers) {
        if (numbers.size() != LOTTO_RANGE) {
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
        return TO_STRING_PREFIX + this.value.stream()
                .map(LottoNumber::toString)
                .collect(Collectors.joining(PRINT_JOIN_DELIMITER)) + TO_STRING_SUFFIX;
    }
}
