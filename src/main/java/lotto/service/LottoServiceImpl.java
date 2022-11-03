package lotto.service;

import lotto.model.domain.LottoRun;
import lotto.model.dto.LottoResult;
import lotto.model.dto.PurchaseAmount;
import lotto.model.dto.WinLotto;
import lotto.model.vo.Lottos;
import lotto.model.vo.PurchaseCount;

public class LottoServiceImpl implements LottoService {

    /**
     * 구입금액으로 로또 구매 개수 계산
     *
     * @param purchaseAmount 구입금액
     * @return 구입한 로또 개수
     */
    @Override
    public PurchaseCount getPurchaseCount(PurchaseAmount purchaseAmount) {
        return LottoRun.getPurchaseCount(purchaseAmount.getPurchaseAmount());
    }

    @Override
    public Lottos generateAutoLotto(PurchaseCount purchaseCount) {
        return null;
    }

    @Override
    public LottoResult checkLottoResult(WinLotto winLotto, Lottos lottos) {
        return null;
    }
}
