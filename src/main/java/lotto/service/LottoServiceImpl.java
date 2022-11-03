package lotto.service;

import java.util.Collections;
import lotto.model.constants.LottoConstants;
import lotto.model.domain.LottoRun;
import lotto.model.dto.LottoResult;
import lotto.model.dto.PurchaseAmount;
import lotto.model.dto.WinLotto;
import lotto.model.vo.Lotto;
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

    /**
     * 구입한 개수만큼 로또 발급
     *
     * @param purchaseCount 구입 개수
     * @return 발급한 로또(전체)
     */
    @Override
    public Lottos generateAutoLotto(PurchaseCount purchaseCount) {
        Lottos lottos = new Lottos();
        for (int i = 0; i < purchaseCount.getPurchaseCount(); i++) {
            addOneLotto(lottos);
        }
        return lottos;
    }

    /**
     * 로또 한 장 생성
     *
     * @return 생성한 로또(1장)
     */
    public Lotto generateOneLotto() {
        Lotto lotto = new Lotto();
        Collections.shuffle(LottoConstants.LOTTO_NUMBER_POOL);
        for (int i = 0; i < LottoConstants.LOTTO_NUMBER_COUNT; i++) {
            lotto.addLottoNumber(LottoConstants.LOTTO_NUMBER_POOL.get(i));
        }
        lotto.sortNumbers();
        return lotto;
    }

    /**
     * 생성한 로또 추가
     *
     * 중복여부 검사하여 이미 추가된 경우 다시 생성하여 추가
     * @param lottos 발급된 로또 목록
     */
    public void addOneLotto(Lottos lottos) {
        Lotto lotto;
        do {
            lotto = generateOneLotto();
        } while (!lottos.addLotto(lotto));
    }

    @Override
    public LottoResult checkLottoResult(WinLotto winLotto, Lottos lottos) {
        return null;
    }
}
