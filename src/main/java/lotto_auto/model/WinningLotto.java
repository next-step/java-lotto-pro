package lotto_auto.model;

import java.util.Set;

public class WinningLotto {
    private final LottoNumber bonusBall;
    private final Lotto lotto;
    public WinningLotto(Lotto lotto, LottoNumber bonusBall) {
        this.lotto = lotto;
        this.bonusBall = bonusBall;
        checkDuplicateNumber();
    }

    private void checkDuplicateNumber() {
        if (lotto.isContain(bonusBall)) {
            throw new IllegalArgumentException(LottoNumbers.EXIST_DUPLICATE_VALUE);
        }
    }

    public LottoRank matches(Lotto from) {
        int count = lotto.countSameLottoNumber(from);
        return LottoRank.getLottoRuleFromMatchedCount(count,  from.isContain(bonusBall));
    }

}
