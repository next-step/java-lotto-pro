package study.step3.domain.lottonumber;

import study.step3.message.LottoNumberMessage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumbers {

    private static final int ACCEPTABLE_LOTTO_NUMBER_SIZE = 6;
    private final List<LottoNumber> lottoNumbers;

    public LottoNumbers(final List<LottoNumber> lottoNumbers) {
        validateLottoNumbers(lottoNumbers);
        this.lottoNumbers = new ArrayList<>(lottoNumbers);
    }

    public static LottoNumbers of(int... numbers) {
        List<LottoNumber> lottoNumbers = Arrays.stream(numbers)
                .mapToObj(LottoNumber::of)
                .collect(Collectors.toList());
        return new LottoNumbers(lottoNumbers);
    }

    public static LottoNumbers of(String... numbers) {
        List<LottoNumber> lottoNumbers = Arrays.stream(numbers)
                .map(LottoNumber::of)
                .collect(Collectors.toList());
        return new LottoNumbers(lottoNumbers);
    }

    private void validateLottoNumbers(List<LottoNumber> lottoNumbers) {
        validateIsSixLottoNumbers(lottoNumbers);
        validateHasDuplicatedLottoNumber(lottoNumbers);
    }

    private void validateIsSixLottoNumbers(List<LottoNumber> lottoNumbers) {
        if(lottoNumbers.size() != ACCEPTABLE_LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(LottoNumberMessage.ERROR_SHOULD_BE_GIVEN_SIX_LOTTO_NUMBERS.message());
        }
    }

    private void validateHasDuplicatedLottoNumber(List<LottoNumber> lottoNumbers) {
        HashSet<LottoNumber> lottoNumberHashSet = new HashSet<>(lottoNumbers);
        if(lottoNumberHashSet.size() != ACCEPTABLE_LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(LottoNumberMessage.ERROR_SHOULD_BE_NOT_DUPLICATED_LOTTO_NUMBER.message());
        }
    }

    public long match(final LottoNumbers otherLottoNumbers) {
        return this.lottoNumbers.stream()
                .filter(otherLottoNumbers::contains)
                .count();
    }

    public boolean contains(LottoNumber lottoNumber) {
        return this.lottoNumbers.contains(lottoNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LottoNumbers that = (LottoNumbers) o;

        return lottoNumbers.equals(that.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return lottoNumbers.hashCode();
    }

    @Override
    public String toString() {
        return lottoNumbers.stream().map(LottoNumber::toString).collect(Collectors.joining(", "));
    }
}
