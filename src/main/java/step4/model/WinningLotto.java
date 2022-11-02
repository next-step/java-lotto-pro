package step4.model;

import step4.constant.ErrorMessageConstant;
import step4.exception.LottoFormatException;
import step4.util.StringUtil;

import java.util.Objects;

public class WinningLotto {
    private final Lotto lotto;
    private final LottoNumber bonusNo;

    public WinningLotto(Lotto lotto, LottoNumber bonusNo) {
        if (lotto.isContains(bonusNo)) {
            throw new LottoFormatException(ErrorMessageConstant.BONUS_NUMBER_IN_LOTTO_WIN_RESULT);
        }
        this.lotto = lotto;
        this.bonusNo = bonusNo;
    }

    public WinningLotto(String lottoNumbers, String bonusNo) {
        this(new Lotto(StringUtil.parseLottoText(lottoNumbers)), new LottoNumber(bonusNo));
    }

    public Rank match(Lotto userLotto) {
        int matchCount = this.lotto.getEqualCount(userLotto);
        boolean isBonusNumber = userLotto.isContains(bonusNo);

        return Rank.valueOf(matchCount, isBonusNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        WinningLotto that = (WinningLotto) o;
        return Objects.equals(lotto, that.lotto) && Objects.equals(bonusNo, that.bonusNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lotto, bonusNo);
    }
}
