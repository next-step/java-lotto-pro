package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import lotto.util.LottoUtil;

public class Lotto {
    private final List<LottoNumber> purchaseLottoList;

    public Lotto(String purchaseMoney) {
        Money money = new Money(purchaseMoney);
        this.purchaseLottoList = new ArrayList<>();
        for (int i = 0; i < money.count(); i++) {
            purchaseLottoList.add(new LottoNumber(LottoUtil.generate()));
        }
    }

    public Lotto(List<LottoNumber> purchaseLottoList) {
        this.purchaseLottoList = purchaseLottoList;
    }

    public List<LottoNumber> getPurchaseLottoList() {
        return Collections.unmodifiableList(purchaseLottoList);
    }

    public LottoResult getResult(LottoNumber winningLotto) {
        LottoResult result = new LottoResult();
        for (LottoNumber lottoNumber : purchaseLottoList) {
            result.putPrize(lottoNumber.calculateWinPrize(winningLotto));
        }
        return result;
    }
}
