package lotto.domain;

import lotto.domain.exception.CountOfLottoNumberException;
import lotto.domain.exception.DuplicateOfLottoNumberException;

import java.util.*;
import java.util.stream.Collectors;

public final class Lotto {

    private static final String SEPARATOR = ",";
    private static final int NUMBER_LIMIT_SIZE = 6;

    private final List<LottoNumber> lottoNumbers;

    private Lotto(final List<Integer> numbers) {
        lottoNumbers = numbers.stream()
                .map(LottoNumber::from)
                .collect(Collectors.toList());
    }

    public static Lotto from(final String inputs) {
        List<Integer> numbers = Arrays.stream(inputs.split(SEPARATOR))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        validate(numbers);
        return new Lotto(numbers);
    }

    public static Lotto from(final List<Integer> numbers) {
        validate(numbers);
        return new Lotto(numbers);
    }

    private static void validate(final List<Integer> numbers) {
        if (numbers.size() != NUMBER_LIMIT_SIZE) {
            throw new CountOfLottoNumberException();
        }
        if (new HashSet<>(numbers).size() != NUMBER_LIMIT_SIZE) {
            throw new DuplicateOfLottoNumberException();
        }
    }

    public int countMatchingNumber(final Lotto comparableLotto) {
        int matchingCount = 0;
        for (LottoNumber lottoNumber : comparableLotto.lottoNumbers) {
            matchingCount += Collections.frequency(this.lottoNumbers, lottoNumber);
        }
        return matchingCount;
    }

    public boolean isContainLottoNumber(LottoNumber bonusBall) {
        return lottoNumbers.contains(bonusBall);
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(lottoNumbers, lotto.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }

}
