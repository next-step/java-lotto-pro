package lotto.service;

import static lotto.domain.LottoPayment.*;

import lotto.domain.LottoResult;
import lotto.domain.LottoReturnRate;

public class LottoResultService {

    private LottoResult lottoResult;

    public LottoResultService(LottoResult result) {
        this.lottoResult = result;
    }

    public long calculateWinningMoney() {
        return lottoResult.calculateWinningMoney();
    }

    public LottoReturnRate calculateReturnRate(int buyCount) {
        return new LottoReturnRate(calculateWinningMoney(), buyCount * PRICE);
    }
}
