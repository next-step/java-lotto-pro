package lotto.domain;

import lotto.domain.common.Constant;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Lotto {

    private static final String THE_LOTTERY_MUST_CONSIST_OF_6_DIGITS = "The lottery must consist of 6 digits.";
    private static final String THE_LOTTERY_MUST_NOT_HAVE_DUPLICATE_NUMBERS = "The lottery must not have duplicate numbers.";

    private final List<LottoNumber> lottoNumbers;

    private Lotto(final List<Integer> lottoNumber) {
        this.lottoNumbers = lottoNumber.stream()
                .map(LottoNumber::from)
                .collect(Collectors.toList());
    }

    public static Lotto from(final List<Integer> lottoNumber) {
        validate(lottoNumber);
        return new Lotto(lottoNumber);
    }

    private static void validate(final List<Integer> lottoNumber) {
        if( lottoNumber.size() != Constant.LOTTO_LIMIT_SIZE) {
            throw new IllegalArgumentException(THE_LOTTERY_MUST_CONSIST_OF_6_DIGITS);
        }
        if( new HashSet<>(lottoNumber).size() != Constant.LOTTO_LIMIT_SIZE ) {
            throw new IllegalArgumentException(THE_LOTTERY_MUST_NOT_HAVE_DUPLICATE_NUMBERS);
        }
    }

    public List<LottoNumber> getLottoNumbers() {
        return this.lottoNumbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(lottoNumbers, lotto.lottoNumbers);
    }
}
