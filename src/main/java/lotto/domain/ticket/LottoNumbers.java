package lotto.domain.ticket;

import lotto.domain.number.LottoNumber;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoNumbers {
    private static final String LOTTO_NUMBERS_SIZE_IS_NOT_EQUAL_SIX_EXCEPTION_STATEMENT = "로또번호의 개수 6개가 아닙니다.";
    private static final int LOTTO_NUMBERS_SIZE = 6;
    private static final String LOTTO_NUMBERS_IS_NULL_EXCEPTION_STATEMENT = "입력값이 null입니다.";

    protected final Set<LottoNumber> lottoNumbers;

    protected LottoNumbers(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers.stream()
            .map(LottoNumber::from)
            .collect(Collectors.toSet());
        validate();
    }

    public static LottoNumbers from(List<Integer> numbers) {
        if (Objects.isNull(numbers)) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_IS_NULL_EXCEPTION_STATEMENT);
        }
        return new LottoNumbers(numbers);
    }

    private void validate() {
        if (lottoNumbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_SIZE_IS_NOT_EQUAL_SIX_EXCEPTION_STATEMENT);
        }
    }

    public boolean contains(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    public Set<LottoNumber> lottoNumbers() {
        return lottoNumbers;
    }
}
