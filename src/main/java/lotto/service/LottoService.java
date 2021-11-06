package lotto.service;

import lotto.domain.LottoFactory;
import lotto.domain.LottoHelper;
import lotto.domain.LottoNumbers;

public class LottoService {

    public int countPurchasableLotto(int amount) {
        return LottoHelper.countPurchasableLotto(amount);
    }

    public LottoNumbers createLottoNumbers() {
        return LottoFactory.createLottoNumbers();
    }

    public int countWinningNumber(LottoNumbers winningLottoNumbers, LottoNumbers myLottoNumbers) {
        return LottoHelper.countWinningNumber(winningLottoNumbers, myLottoNumbers);
    }

    /**
     * 수익률 계산
     */
    public double getRateOfReturn(int purchaseCount, int winningAmount) {
        return LottoHelper.getRateOfReturn(purchaseCount, winningAmount);
    }
}
