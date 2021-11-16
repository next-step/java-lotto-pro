package lotto.domain;

import lotto.domain.common.Constant;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class WinningLotto {

    public static final String BONUS_NUMBERS_ARE_DUPLICATED_IN_LOTTERY_NUMBERS = "Bonus numbers are duplicated in lottery numbers.";
    public static final int MATCH_ONE = 1;
    public static final int MIS_MATCH_ZERO = 0;

    private final Lotto lottoNumbers;
    private final LottoNumber bonusNumber;

    private WinningLotto(final Lotto lottoNumbers, final LottoNumber bonusNumber) {
        validateBonus(lottoNumbers, bonusNumber);
        this.lottoNumbers = lottoNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static WinningLotto from(final List<Integer> winningLottoNumbers, final int bonusBall) {
        return new WinningLotto(Lotto.from(winningLottoNumbers), LottoNumber.from(bonusBall));
    }

    public static WinningLotto from(final String inputWinningLottoNumbers, final String inputBonusBall) {
        List<Integer> winningLottoNumbers = Arrays.stream(inputWinningLottoNumbers.split(Constant.SEPERATOR))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return new WinningLotto(Lotto.from(winningLottoNumbers), LottoNumber.from(Integer.parseInt(inputBonusBall)));
    }

    private static void validateBonus(final Lotto winningLottoNumbers, final LottoNumber bonusBall) {
        if( winningLottoNumbers.getLottoNumbers().contains(bonusBall) ) {
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
        if( this.lottoNumbers.getLottoNumbers().contains(lottoNumber) ) {
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
