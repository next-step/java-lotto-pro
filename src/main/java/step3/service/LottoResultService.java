package step3.service;

import step3.domain.LottoPayment;
import step3.domain.LottoResult;
import step3.domain.LottoReturnRate;
import step3.domain.LottoWinningMoney;

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
