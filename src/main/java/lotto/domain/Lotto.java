package lotto.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {

    private static final int LOTTO_NUMBER_COUNT = 6;

    private static final String LOTTO_NUMBER_COUNT_MESSAGE = "로또 번호는 6개가 입력되야 합니다.";

    private static final String LOTTO_NUMBER_DUPLICATE_MESSAGE = "로또 번호에 중복된 값이 포함되어 있습니다.";

    private final List<LottoNumber> lottoNumbers;

    private Lotto(final List<LottoNumber> lottoNumbers) {
        validate(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public static Lotto from(final List<Integer> numbers) {
        return new Lotto(numbers.stream()
            .map(number -> LottoNumber.from(number))
            .collect(Collectors.toList()));
    }

    private void validate(final List<LottoNumber> lottoNumbers) {
        validateCount(lottoNumbers);
        validateDuplicate(lottoNumbers);
    }

    private void validateCount(final List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(LOTTO_NUMBER_COUNT_MESSAGE);
        }
    }

    private void validateDuplicate(final List<LottoNumber> lottoNumbers) {
        Set<LottoNumber> numberSet = new HashSet<>(lottoNumbers);

        if (numberSet.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(LOTTO_NUMBER_DUPLICATE_MESSAGE);
        }
    }

    public int matchLottoNumber(final Lotto winningLotto) {
        int matchCount = 0;

        for (LottoNumber targetNumber: winningLotto.lottoNumbers) {
            matchCount += Collections.frequency(lottoNumbers, targetNumber);
        }

        return matchCount;
    }

    public boolean matchBounsNumber(final LottoNumber bounsNumber) {
        return this.lottoNumbers.contains(bounsNumber);
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }
}
