package lotto.service;

import lotto.model.domain.Lotto;
import lotto.model.domain.Lottos;
import lotto.model.domain.Profit;
import lotto.model.domain.PurchaseInfo;
import lotto.model.domain.WinLotto;
import lotto.model.domain.WinResult;

public interface LottoService {

    /**
     * 수동 로또 발급
     *
     * @param lottos             발급된 로또
     * @param manualLottoNumbers 입력된 수동 로또 번호 목록
     */
    void generateManualLotto(Lottos lottos, String[] manualLottoNumbers);

    /**
     * 수동 로또 추가
     *
     * @param lottos      발급된 로또
     * @param manualLotto 수동 로또 입력값
     */
    void addManualLotto(Lottos lottos, String manualLotto);

    /**
     * 자동 로또 발급
     *
     * @param lottos       발급된 로또
     * @param purchaseInfo 구입정보
     */
    void generateAutoLotto(Lottos lottos, PurchaseInfo purchaseInfo);

    /**
     * 로또 한 장 생성
     *
     * @return 생성한 로또(1장)
     */
    Lotto generateOneLotto();

    /**
     * 생성한 로또 추가
     * <p>
     * 중복여부 검사하여 이미 추가된 경우 다시 생성하여 추가
     *
     * @param lottos 발급된 로또 목록
     */
    void addOneLotto(Lottos lottos);

    /**
     * 로또 당첨 결과 확인
     *
     * @param winLotto 당첨 로또 번호
     * @param lottos   발급된 로또 목록
     * @return 당첨기준에 따른 로또 당첨 결과
     */
    WinResult checkLottoResult(WinLotto winLotto, Lottos lottos);

    /**
     * 수익률 계산
     *
     * @param purchaseInfo 구입정보
     * @param winResult    당첨 결과
     * @return 수익률
     */
    Profit calculateProfit(PurchaseInfo purchaseInfo, WinResult winResult);
}
