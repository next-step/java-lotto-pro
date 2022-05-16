package lotto.lotto;

import lotto.LottoPrize;

import static java.util.Objects.requireNonNull;

public class WinningLotto {

    private final String maybeLottoNumbers;

    protected WinningLotto(String maybeLottoNumbers) {
        this.maybeLottoNumbers =  requireNonNull(maybeLottoNumbers, "lotto");;
    }

    public static WinningLotto of(String maybeLottoNumbers) {
        return new WinningLotto(maybeLottoNumbers);
    }

    public LottoPrize guess(Lotto lotto) {
//        final int matcheCount = this.lotto.countMatches(lotto);
//        final boolean matchBonus = lotto.contains(bonusLottoNumber);
        return null;
    }
}
