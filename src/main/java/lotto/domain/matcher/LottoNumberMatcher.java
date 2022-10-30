package lotto.domain.matcher;

import lotto.domain.lottonumber.LottoNumbers;
import lotto.domain.lottonumber.purchase.Purchase;
import lotto.domain.result.DefaultLottoResult;
import lotto.domain.winningnumber.WinningNumber;

public class LottoNumberMatcher {

    private LottoNumbers lottoNumbers;
    private WinningNumber winningNumber;
    private DefaultLottoResult lottoResult;

    public LottoNumberMatcher(LottoNumbers lottoNumbers, String winningNumber) {
        this.lottoNumbers = lottoNumbers;
        this.winningNumber = new WinningNumber(winningNumber);
        this.lottoResult = new DefaultLottoResult();
    }

    public DefaultLottoResult result() {
        lottoNumbers.createMatchCount(winningNumber)
                .forEach(matchCount -> lottoResult.calculateTotalCount(matchCount));
        return lottoResult;
    }

    public String makeProfitMargin(Purchase purchase) {
        return purchase.makeProfitMargin(lottoResult.totalProfit());
    }
}
