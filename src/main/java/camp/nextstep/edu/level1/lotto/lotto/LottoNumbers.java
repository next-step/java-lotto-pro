package camp.nextstep.edu.level1.lotto.lotto;

import camp.nextstep.edu.until.CollectionHelper;

import java.util.*;
import java.util.stream.Collectors;

public class LottoNumbers {
    private static final int LOTTO_RANGE = 6;
    private static final String LOTTO_NUMBER_DELIMITER = ", ";
    private static final String TO_STRING_PREFIX = "[";
    private static final String TO_STRING_SUFFIX = "]";

    private final Set<LottoNumber> lottoNumbers = new HashSet<>();

    public LottoNumbers(Collection<Integer> numbers) {
        checkLottoNumberSize(numbers.size());
        addAll(numbers);
    }

    public LottoNumbers(List<LottoNumber> numbers) {
        checkLottoNumberSize(numbers.size());
        lottoNumbers.addAll(numbers);
    }

    public LottoNumbers(String lottoNumbersWithDelimiter) {
        String[] splitResult = Arrays.stream(lottoNumbersWithDelimiter.split(LOTTO_NUMBER_DELIMITER))
                .map(String::trim)
                .toArray(String[]::new);
        checkLottoNumberSize(splitResult.length);

        addAll(CollectionHelper.arrayStringToIntegerList(splitResult));
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

    private void checkLottoNumberSize(int count) {
        if (count != LOTTO_RANGE) {
            throw new IllegalArgumentException("로또는 6 자리의 숫자만 허용됩니다.");
        }
    }

    @Override
    public String toString() {
        return TO_STRING_PREFIX + this.lottoNumbers.stream()
                .map(LottoNumber::toString)
                .collect(Collectors.joining(LOTTO_NUMBER_DELIMITER)) + TO_STRING_SUFFIX;
    }
}
