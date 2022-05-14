package lotto.lotto;

import lotto.LottoPrize;

public class WinningLotto {

    private final Lotto lotto;
    private final LottoNumber bonusLottoNumber;

    protected WinningLotto(Lotto lotto, LottoNumber bonusLottoNumber) {
        this.lotto = lotto;
        this.bonusLottoNumber = bonusLottoNumber;
    }

    public static WinningLotto of(Lotto lotto, LottoNumber bonusLottoNumber) {
        return new WinningLotto(lotto, bonusLottoNumber);
    }

    private static void validate(Lotto lotto, LottoNumber bonusLottoNumber) {
    }

    public LottoPrize guess(Lotto lotto) {
        return null;
    }
}
