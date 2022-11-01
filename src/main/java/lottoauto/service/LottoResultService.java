package lottoauto.service;

import lottoauto.domain.LottoPayment;
import lottoauto.domain.LottoResult;
import lottoauto.domain.LottoReturnRate;

public class LottoResultService {

    private LottoResult lottoResult;

    public LottoResultService(LottoResult result) {
        this.lottoResult = result;
    }

    public int calculateWinningMoney() {
        return lottoResult.calculateWinningMoney();
    }

    public LottoReturnRate calculateReturnRate(int buyCount) {
        return new LottoReturnRate(calculateWinningMoney(), buyCount * LottoPayment.PRICE);
    }
}
