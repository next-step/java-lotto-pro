package lotto.domain;

import lotto.domain.common.Constant;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {

    private static final String THE_LOTTERY_MUST_CONSIST_OF_6_DIGITS = "The lottery must consist of 6 digits.";
    private static final String THE_LOTTERY_MUST_NOT_HAVE_DUPLICATE_NUMBERS = "The lottery must not have duplicate numbers.";

    private final List<LottoNumber> lottoNums;

    private Lotto(final List<Integer> numbers) {
        lottoNums = numbers.stream()
                .map(LottoNumber::from)
                .collect(Collectors.toList());
    }

    public static Lotto from(final List<Integer> numbers) {
        validate(numbers);
        return new Lotto(numbers);
    }

    public static Lotto from(final String input) {
        List<Integer> lottoNums = Arrays.stream(input.split(Constant.SEPERATOR))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        validate(lottoNums);
        return new Lotto(lottoNums);
    }

    private static void validate(final List<Integer> numbers) {
        if( numbers.size() != Constant.LOTTO_LIMIT_SIZE) {
            throw new IllegalArgumentException(THE_LOTTERY_MUST_CONSIST_OF_6_DIGITS);
        }
        if( new HashSet<>(numbers).size() != Constant.LOTTO_LIMIT_SIZE ) {
            throw new IllegalArgumentException(THE_LOTTERY_MUST_NOT_HAVE_DUPLICATE_NUMBERS);
        }
    }

    public int countMatchingNumber(final Lotto comparableLotto) {
        int matchingCount = 0;
        for (LottoNumber lottoNumber : comparableLotto.lottoNums) {
            matchingCount += Collections.frequency(this.lottoNums, lottoNumber);
        }
        return matchingCount;
    }

    public List<LottoNumber> getLottoNumbers() {
        return this.lottoNums;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(lottoNums, lotto.lottoNums);
    }
}
