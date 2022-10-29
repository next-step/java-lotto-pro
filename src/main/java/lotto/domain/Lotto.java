package lotto.domain;

import java.util.Iterator;
import lotto.domain.lottonumber.LottoNumbers;
import lotto.domain.lottonumber.purchase.Purchase;
import lotto.domain.result.DefaultLottoResult;
import lotto.domain.winningnumber.WinningNumber;

public class Lotto {

    private LottoNumbers lottoNumbers;
    private Purchase purchase;
    private WinningNumber winningNumber;
    private DefaultLottoResult lottoResult;

    public Lotto(String purchase, String winningNumber) {
        this.purchase = new Purchase(purchase);
        this.lottoNumbers = new LottoNumbers(this.purchase);
        this.winningNumber = new WinningNumber(winningNumber);
        this.lottoResult = new DefaultLottoResult();
    }

    public DefaultLottoResult result() {
        for (Iterator<Integer> lottoNumberIterator : lottoNumbers.createIterators()) {
            lottoResult.calculateTotalCount(winningNumber.matchNumber(lottoNumberIterator));
        }
        return lottoResult;
    }

    public String makeProfitMargin() {
        return purchase.makeProfitMargin(lottoResult.totalProfit());
    }
}
