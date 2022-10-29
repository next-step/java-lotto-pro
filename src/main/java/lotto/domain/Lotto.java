package lotto.domain;

import java.util.Iterator;
import lotto.domain.lottonumber.LottoNumbers;
import lotto.domain.lottonumber.purchase.Purchase;
import lotto.domain.result.DefaultLottoResult;
import lotto.domain.winningnumber.WinningNumber;

public class Lotto {

    private LottoNumbers lottoNumbers;
    private WinningNumber winningNumber;
    private DefaultLottoResult lottoResult;

    public Lotto(LottoNumbers lottoNumbers, String winningNumber) {
        this.lottoNumbers = lottoNumbers;
        this.winningNumber = new WinningNumber(winningNumber);
        this.lottoResult = new DefaultLottoResult();
    }

    public DefaultLottoResult result() {
        for (Iterator<Integer> lottoNumberIterator : lottoNumbers.createIterators()) {
            lottoResult.calculateTotalCount(winningNumber.matchNumber(lottoNumberIterator));
        }
        return lottoResult;
    }

    public String makeProfitMargin(Purchase purchase) {
        return purchase.makeProfitMargin(lottoResult.totalProfit());
    }
}
