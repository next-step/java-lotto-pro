package lotto.service;

import java.util.Collections;
import lotto.model.constants.ErrorMessage;
import lotto.model.constants.LottoConstants;
import lotto.model.domain.Lotto;
import lotto.model.domain.LottoNumber;
import lotto.model.domain.Lottos;
import lotto.model.domain.MatchCounts;
import lotto.model.domain.Profit;
import lotto.model.domain.PurchaseInfo;
import lotto.model.domain.WinLotto;
import lotto.model.domain.WinResult;

public class LottoServiceImpl implements LottoService {

    /**
     * 수동 로또 발급
     *
     * @param lottos             발급된 로또
     * @param manualLottoNumbers 입력된 수동 로또 번호 목록
     */
    @Override
    public void generateManualLotto(Lottos lottos, String[] manualLottoNumbers) {
        for (String manualLotto : manualLottoNumbers) {
            addManualLotto(lottos, manualLotto);
        }
    }

    /**
     * 수동 로또 추가
     *
     * @param lottos      발급된 로또
     * @param manualLotto 수동 로또 입력값
     */
    @Override
    public void addManualLotto(Lottos lottos, String manualLotto) {
        if (!lottos.addLotto(new Lotto(manualLotto))) {
            throw new IllegalArgumentException(ErrorMessage.MANUAL_LOTTO_DUPLICATE);
        }
    }

    /**
     * 자동 로또 발급
     *
     * @param lottos       발급된 로또
     * @param purchaseInfo 구입정보
     */
    @Override
    public void generateAutoLotto(Lottos lottos, PurchaseInfo purchaseInfo) {
        for (int i = 0; i < purchaseInfo.getAutoLottoCount(); i++) {
            addOneLotto(lottos);
        }
    }

    /**
     * 로또 한 장 생성
     *
     * @return 생성한 로또(1장)
     */
    @Override
    public Lotto generateOneLotto() {
        Lotto lotto = new Lotto();
        Collections.shuffle(LottoConstants.LOTTO_NUMBER_POOL);
        for (int i = 0; i < LottoConstants.LOTTO_NUMBER_COUNT; i++) {
            lotto.addLottoNumber(LottoNumber.getLottoNumberByInt(LottoConstants.LOTTO_NUMBER_POOL.get(i)));
        }
        lotto.sortNumbers();
        return lotto;
    }

    /**
     * 생성한 로또 추가
     * <p>
     * 중복여부 검사하여 이미 추가된 경우 다시 생성하여 추가
     *
     * @param lottos 발급된 로또 목록
     */
    @Override
    public void addOneLotto(Lottos lottos) {
        Lotto lotto;
        do {
            lotto = generateOneLotto();
        } while (!lottos.addLotto(lotto));
    }

    /**
     * 로또 당첨 결과 확인
     *
     * @param winLotto 당첨 로또 번호
     * @param lottos   발급된 로또 목록
     * @return 당첨기준에 따른 로또 당첨 결과
     */
    @Override
    public WinResult checkLottoResult(WinLotto winLotto, Lottos lottos) {
        // 일치 개수 리스트 생성
        MatchCounts matchCounts = lottos.compareWinLotto(winLotto);
        // 당첨 기준에 따라 WinResult 생성
        return new WinResult(matchCounts);
    }

    /**
     * 수익률 계산
     *
     * @param purchaseInfo 구입정보
     * @param winResult    당첨 결과
     * @return 수익률
     */
    @Override
    public Profit calculateProfit(PurchaseInfo purchaseInfo, WinResult winResult) {
        long buyAmount = purchaseInfo.getPurchaseAmount();
        long winAmount = winResult.calculateWinAmount();
        return new Profit(buyAmount, winAmount);
    }
}
