package study.step3.domain.lotto;

import study.step3.domain.lottonumber.LottoMatchResult;
import study.step3.domain.lottonumber.LottoNumber;
import study.step3.message.LottoMessage;

public class WinningLotto {

    private final Lotto winningLotto;
    private final LottoNumber bonusNumber;

    public WinningLotto(Lotto winningLotto, LottoNumber bonusNumber) {
        validateBonusNumber(winningLotto, bonusNumber);
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(Lotto winningLotto, LottoNumber bonusNumber) {
        if(winningLotto.isMatchedBonusLottoNumber(bonusNumber)) {
            throw new IllegalArgumentException(LottoMessage.ERROR_BONUS_NUMBER_IS_INCLUDING_WINNING_NUMBERS.message());
        }
    }

    public LottoMatchResult matchLotto(Lotto lotto) {
        long lottoMatchCount = lotto.matchLotto(this.winningLotto);
        boolean isMatchedBonusLottoNumber = lotto.isMatchedBonusLottoNumber(this.bonusNumber);
        return new LottoMatchResult(lottoMatchCount, isMatchedBonusLottoNumber);
    }
}
