package lotto.service;

import lotto.model.dto.LottoResult;
import lotto.model.dto.PurchaseAmount;
import lotto.model.dto.WinLotto;
import lotto.model.vo.Lottos;
import lotto.model.vo.PurchaseCount;

public interface LottoService {

    /**
     * 구입금액으로 로또 구매 개수 계산
     *
     * @param purchaseAmount 구입금액
     * @return 구입한 로또 개수
     */
    PurchaseCount getPurchaseCount(PurchaseAmount purchaseAmount);

    Lottos generateAutoLotto(PurchaseCount purchaseCount);

    LottoResult checkLottoResult(WinLotto winLotto, Lottos lottos);
}
