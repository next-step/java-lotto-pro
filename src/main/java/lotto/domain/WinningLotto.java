package lotto.domain;

import static lotto.domain.LottoResults.ADD_COUNT_AMOUNT;
import static lotto.domain.LottoResults.DEFALUT_COUNT;

import common.constant.ErrorCode;
import java.util.HashMap;
import java.util.Map;

public class WinningLotto {

    private final Lotto winningLotto;
    private final LottoNumber bonusLottoNumber;

    public WinningLotto(Lotto winningLotto, LottoNumber bonusLottoNumber) {
        validateBonusLottoNumber(winningLotto, bonusLottoNumber);
        this.winningLotto = winningLotto;
        this.bonusLottoNumber = bonusLottoNumber;
    }

    private void validateBonusLottoNumber(Lotto winningLotto, LottoNumber bonusLottoNumber) {
        if(winningLotto.isMatchLottoNumber(bonusLottoNumber)) {
            throw new IllegalArgumentException(ErrorCode.보너스_볼은_당첨_로또의_각_숫자와_중복_불가.getErrorMessage());
        }
    }

    public int findLottoMatchCount(Lotto lotto) {
        return lotto.findLottoMatchCount(winningLotto);
    }

    public boolean isMatchBonusLottoNumber(Lotto lotto) {
        return lotto.isMatchLottoNumber(bonusLottoNumber);
    }

    public LottoResults createLottoResults(Lottos lottos) {
        Map<LottoPrize, Integer> lottoResults = new HashMap<>();
        for(Lotto lotto: lottos.unmodifiedLottos()) {
            int matchCount = findLottoMatchCount(lotto);
            boolean isMatchBonusLottoNumber = isMatchBonusLottoNumber(lotto);
            LottoPrize lottoPrize = LottoPrize.findLottoPrize(matchCount, isMatchBonusLottoNumber);
            lottoResults.put(lottoPrize, lottoResults.getOrDefault(lottoPrize, DEFALUT_COUNT) + ADD_COUNT_AMOUNT);
        }
        return LottoResults.createLottoResults(lottoResults);
    }
}
