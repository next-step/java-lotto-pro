package lotto.lotto;

import lotto.LottoPrize;

import static java.util.Objects.requireNonNull;

public class WinningLotto {

    private final Lotto lotto;
    private final LottoNumber bonusLottoNumber;

    protected WinningLotto(Lotto lotto, LottoNumber bonusLottoNumber) {
        validate(lotto, bonusLottoNumber);
        this.lotto = lotto;
        this.bonusLottoNumber = bonusLottoNumber;
    }

    public static WinningLotto of(Lotto lotto, LottoNumber bonusLottoNumber) {
        return new WinningLotto(lotto, bonusLottoNumber);
    }

    private static void validate(Lotto lotto, LottoNumber bonusLottoNumber) {
        requireNonNull(lotto, "lotto");
        requireNonNull(bonusLottoNumber, "bonusLottoNumber");
        if (lotto.contains(bonusLottoNumber)) {
            throw new AlreadyExistsBonusLottoNumberException(lotto, bonusLottoNumber);
        }
    }

    public LottoPrize guess(Lotto lotto) {
        final int matcheCount = this.lotto.countMatches(lotto);
        final boolean matchBonus = lotto.contains(bonusLottoNumber);
        return LottoPrize.valueOf(matcheCount, matchBonus);
    }
}
