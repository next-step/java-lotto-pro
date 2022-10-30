package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import lotto.util.LottoUtil;

public class Lotto {
    private final List<LottoNumbers> purchaseLottoList;

    public Lotto(Integer money) {
        LottoMoney lottoMoney = new LottoMoney(money);
        this.purchaseLottoList = new ArrayList<>();
        for (int i = 0; i < lottoMoney.count(); i++) {
            purchaseLottoList.add(new LottoNumbers(LottoUtil.generate()));
        }
    }

    public Lotto(List<LottoNumbers> purchaseLottoList) {
        this.purchaseLottoList = purchaseLottoList;
    }

    public List<LottoNumbers> getPurchaseLottoList() {
        return Collections.unmodifiableList(purchaseLottoList);
    }

    public LottoResult computeResult(LottoNumbers winningLotto, LottoNumber bonusNumber) {
        validateBonus(winningLotto, bonusNumber);
        LottoResult result = new LottoResult();
        for (LottoNumbers lottoNumbers : purchaseLottoList) {
            result.addCount(lottoNumbers.calculateRank(winningLotto, bonusNumber));
        }
        return result;
    }

    private void validateBonus(LottoNumbers lottoNumbers, LottoNumber bonusNumber) {
        if (lottoNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스번호는 당첨번호와 달라야합니다.");
        }
    }
}
