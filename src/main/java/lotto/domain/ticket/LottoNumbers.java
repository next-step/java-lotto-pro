package lotto.domain.ticket;

import java.util.*;
import java.util.stream.*;

import lotto.domain.number.*;
import lotto.exception.*;

public class LottoNumbers {
    private static final String LOTTO_NUMBERS_SIZE_IS_NOT_EQUAL_SIX_EXCEPTION_STATEMENT = "로또번호의 개수 6개가 아닙니다.(번호 중복 확인)";
    private static final int LOTTO_NUMBERS_SIZE = 6;

    protected final Set<LottoNumber> lottoNumbers;

    protected LottoNumbers(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers.lottoNumbers();
        validate();
    }

    protected LottoNumbers(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers.stream()
            .map(LottoNumber::from)
            .collect(Collectors.toSet());
        validate();
    }

    public static LottoNumbers from(List<Integer> numbers) {
        if (Objects.isNull(numbers)) {
            throw new NullArgumentException(LottoNumbers.class.getSimpleName());
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
