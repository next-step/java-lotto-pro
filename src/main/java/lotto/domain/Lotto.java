package lotto.domain;

import lotto.domain.common.Constant;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Lotto {

    private static final String THE_LOTTERY_MUST_CONSIST_OF_6_DIGITS = "The lottery must consist of 6 digits.";
    private static final String THE_LOTTERY_MUST_NOT_HAVE_DUPLICATE_NUMBERS = "The lottery must not have duplicate numbers.";
    public static final String BONUS_NUMBERS_ARE_DUPLICATED_IN_LOTTERY_NUMBERS = "Bonus numbers are duplicated in lottery numbers.";

    private final List<LottoNumber> lottoNums;
    private final LottoNumber bonus;

    private Lotto(final List<Integer> numbers) {
        this.lottoNums = numbers.stream()
                .map(LottoNumber::from)
                .collect(Collectors.toList());
        this.bonus = null;
    }

    private Lotto(final List<Integer> numbers, final int bonus) {
        this.lottoNums = numbers.stream()
                .map(LottoNumber::from)
                .collect(Collectors.toList());
        this.bonus = LottoNumber.from(bonus);
    }

    public static Lotto from(final List<Integer> numbers) {
        validate(numbers);
        return new Lotto(numbers);
    }

    public static Lotto from(final List<Integer> numbers, final int bonus) {
        validate(numbers);
        validateBonus(numbers, bonus);
        return new Lotto(numbers, bonus);
    }

    public static Lotto from(final String input, final String inputBonus) {
        List<Integer> lottoNums = Arrays.stream(input.split(Constant.SEPERATOR))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        validate(lottoNums);
        int bonus = Integer.parseInt(inputBonus);
        validateBonus(lottoNums, bonus);
        return new Lotto(lottoNums, bonus);
    }

    private static void validate(final List<Integer> numbers) {
        if( numbers.size() != Constant.LOTTO_LIMIT_SIZE) {
            throw new IllegalArgumentException(THE_LOTTERY_MUST_CONSIST_OF_6_DIGITS);
        }
        if( new HashSet<>(numbers).size() != Constant.LOTTO_LIMIT_SIZE ) {
            throw new IllegalArgumentException(THE_LOTTERY_MUST_NOT_HAVE_DUPLICATE_NUMBERS);
        }
    }

    private static void validateBonus(List<Integer> numbers, int bonus) {
        if( numbers.contains(bonus) ) {
            throw new IllegalArgumentException(BONUS_NUMBERS_ARE_DUPLICATED_IN_LOTTERY_NUMBERS);
        }
    }

    public MatchResult countMatchingNumber(final Lotto comparableLotto) {
        int matchNumber = 0;
        for (LottoNumber lottoNumber : comparableLotto.lottoNums) {
            matchNumber += matchNumber(lottoNumber);
        }
        boolean matchBonus = isMatchBonus(comparableLotto);
        return MatchResult.from(matchNumber, matchBonus);
    }

    private boolean isMatchBonus(Lotto comparableLotto) {
        if( comparableLotto.lottoNums.contains(this.bonus) ) {
            return true;
        }
        return false;
    }

    public int matchNumber(LottoNumber lottoNumber) {
        if( this.lottoNums.contains(lottoNumber) ) {
            return 1;
        }
        return 0;
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
