package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import lotto.util.LottoUtil;

public class Lotto {
    private final List<LottoNumbers> lottoNumbersList;

    public Lotto(Integer money, List<LottoNumbers> manualLottoList) {
        LottoMoney lottoMoney = new LottoMoney(money);
        int autoPurchaseCount = computeAutoPurchaseCount(lottoMoney.count(), manualLottoList.size());
        this.lottoNumbersList = new ArrayList<>();
        this.lottoNumbersList.addAll(manualLottoList);
        for (int i = 0; i < autoPurchaseCount; i++) {
            this.lottoNumbersList.add(new LottoNumbers(LottoUtil.generate()));
        }
    }

    private int computeAutoPurchaseCount(int lottoMoneyCount, int manualLottoCount) {
        int autoPurchaseCount = lottoMoneyCount - manualLottoCount;
        if (autoPurchaseCount < 0) {
            throw new IllegalStateException("구입금액보다 수동구매 숫자가 더 많습니다.");
        }
        return autoPurchaseCount;
    }

    public Lotto(List<LottoNumbers> lottoNumbersList) {
        this.lottoNumbersList = lottoNumbersList;
    }

    public List<LottoNumbers> getLottoNumbersList() {
        return Collections.unmodifiableList(lottoNumbersList);
    }

    public LottoResult computeResult(LottoNumbers winningLotto, LottoNumber bonusNumber) {
        validateBonus(winningLotto, bonusNumber);
        LottoResult result = new LottoResult();
        for (LottoNumbers lottoNumbers : lottoNumbersList) {
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
