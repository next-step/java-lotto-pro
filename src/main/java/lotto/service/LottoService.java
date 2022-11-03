package lotto.service;

import lotto.model.dto.LottoResult;
import lotto.model.dto.PurchaseAmount;
import lotto.model.dto.WinLotto;
import lotto.model.vo.Lotto;
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

    /**
     * 구입한 개수만큼 로또 발급
     *
     * @param purchaseCount 구입 개수
     * @return 발급한 로또(전체)
     */
    Lottos generateAutoLotto(PurchaseCount purchaseCount);

    LottoResult checkLottoResult(WinLotto winLotto, Lottos lottos);
    /**
     * 로또 한 장 생성
     *
     * @return 생성한 로또(1장)
     */
    Lotto generateOneLotto();

    /**
     * 생성한 로또 추가
     *
     * 중복여부 검사하여 이미 추가된 경우 다시 생성하여 추가
     * @param lottos 발급된 로또 목록
     */
    void addOneLotto(Lottos lottos);
}
