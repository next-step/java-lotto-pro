package lotto.service;

import lotto.model.dto.PurchaseAmount;
import lotto.model.vo.WinLotto;
import lotto.model.vo.Lotto;
import lotto.model.vo.Lottos;
import lotto.model.vo.Profit;
import lotto.model.vo.PurchaseCount;
import lotto.model.vo.WinResult;

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

    /**
     * 로또 당첨 결과 확인
     *
     * @param winLotto 당첨 로또 번호
     * @param lottos 발급된 로또 목록
     * @return 당첨기준에 따른 로또 당첨 결과
     */
    WinResult checkLottoResult(WinLotto winLotto, Lottos lottos);

    /**
     * 수익률 계산
     *
     * @param purchaseAmount 구입 금액
     * @param winResult 당첨 결과
     * @return 수익률
     */
    Profit calculateProfit(PurchaseAmount purchaseAmount, WinResult winResult);
}
