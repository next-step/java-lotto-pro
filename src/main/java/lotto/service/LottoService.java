package lotto.service;

import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;

public class LottoService {

    public static final int LOTTO_PER_PRICE = 1000;

    public int countPurchasableLotto(int amount) {
        return amount / LOTTO_PER_PRICE;
    }

    public int countWinningNumber(LottoNumbers winningLottoNumbers, LottoNumbers myLottoNumbers) {
        int winningCount = 0;
        for (LottoNumber winningNumber : winningLottoNumbers.getLottoNumbers()) {
            winningCount += checkContainsNumber(myLottoNumbers, winningCount, winningNumber);
        }
        return winningCount;
    }

    private int checkContainsNumber(LottoNumbers myLottoNumbers, int winningCount, LottoNumber winningNumber) {
        if (myLottoNumbers.containsNumber(winningNumber)) {
            return 1;
        }
        return 0;
    }
}
