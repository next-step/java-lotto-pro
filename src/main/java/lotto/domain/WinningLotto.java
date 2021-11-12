package lotto.domain;

import lotto.domain.common.Constant;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class WinningLotto {

    private static final String THE_LOTTERY_MUST_CONSIST_OF_6_DIGITS = "The lottery must consist of 6 digits.";
    private static final String THE_LOTTERY_MUST_NOT_HAVE_DUPLICATE_NUMBERS = "The lottery must not have duplicate numbers.";
    public static final String BONUS_NUMBERS_ARE_DUPLICATED_IN_LOTTERY_NUMBERS = "Bonus numbers are duplicated in lottery numbers.";
    public static final int MATCH_ONE = 1;
    public static final int MIS_MATCH_ZERO = 0;

    private final List<LottoNumber> lottoNumbers;
    private final LottoNumber bonusNumber;

    private WinningLotto(final List<Integer> lottoNumbers, final int bonusNumber) {
        this.lottoNumbers = lottoNumbers.stream()
                .map(LottoNumber::from)
                .collect(Collectors.toList());
        this.bonusNumber = LottoNumber.from(bonusNumber);
    }

    public static WinningLotto from(final List<Integer> winningLottoNumbers, final int bonusBall) {
        validate(winningLottoNumbers);
        validateBonus(winningLottoNumbers, bonusBall);
        return new WinningLotto(winningLottoNumbers, bonusBall);
    }

    public static WinningLotto from(final String inputWinningLottoNumbers, final String inputBonusBall) {
        List<Integer> winningLottoNumbers = Arrays.stream(inputWinningLottoNumbers.split(Constant.SEPERATOR))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        validate(winningLottoNumbers);
        int bonusBall = Integer.parseInt(inputBonusBall);
        validateBonus(winningLottoNumbers, bonusBall);
        return new WinningLotto(winningLottoNumbers, bonusBall);
    }

    private static void validate(final List<Integer> winningLottoNumbers) {
        if( winningLottoNumbers.size() != Constant.LOTTO_LIMIT_SIZE) {
            throw new IllegalArgumentException(THE_LOTTERY_MUST_CONSIST_OF_6_DIGITS);
        }
        if( new HashSet<>(winningLottoNumbers).size() != Constant.LOTTO_LIMIT_SIZE ) {
            throw new IllegalArgumentException(THE_LOTTERY_MUST_NOT_HAVE_DUPLICATE_NUMBERS);
        }
    }

    private static void validateBonus(final List<Integer> winningLottoNumbers, final int bonusBall) {
        if( winningLottoNumbers.contains(bonusBall) ) {
            throw new IllegalArgumentException(BONUS_NUMBERS_ARE_DUPLICATED_IN_LOTTERY_NUMBERS);
        }
    }

    public MatchResult countMatchingNumber(final Lotto lotto) {
        int matchNumber = 0;
        for (LottoNumber lottoNumber : lotto.getLottoNumbers()) {
            matchNumber += matchOfCount(lottoNumber);
        }
        boolean matchBonus = isMatchBonus(lotto);
        return MatchResult.from(matchNumber, matchBonus);
    }

    private boolean isMatchBonus(final Lotto lotto) {
        return lotto.getLottoNumbers().contains(this.bonusNumber);
    }

    public int matchOfCount(final LottoNumber lottoNumber) {
        if( this.lottoNumbers.contains(lottoNumber) ) {
            return MATCH_ONE;
        }
        return MIS_MATCH_ZERO;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningLotto lotto = (WinningLotto) o;
        return Objects.equals(lottoNumbers, lotto.lottoNumbers);
    }
}
