package lotto.service;

import lotto.model.dto.LottoResult;
import lotto.model.dto.PurchaseAmount;
import lotto.model.dto.WinLotto;
import lotto.model.vo.Lottos;
import lotto.model.vo.PurchaseCount;

public interface LottoService {
    PurchaseCount getPurchaseCount(PurchaseAmount purchaseAmount);

    Lottos generateAutoLotto(PurchaseCount purchaseCount);

    LottoResult checkLottoResult(WinLotto winLotto, Lottos lottos);
}
