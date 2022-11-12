package step5.service;

import step5.model.Lotto;
import step5.model.LottoResult;
import step5.model.LottoWinningNos;
import step5.model.Lottos;

import java.util.List;

public class LottoService {
    private static final int DEFAULT_TICKET_PRICE = 1000;

    private LottoGenerator lottoGenerator;

    public LottoService() {
        this.lottoGenerator = new LottoGenerator();
    }

    /**
     * 로또 구매
     *
     * @param money        로또 구입할 돈
     * @param manualLottos 수동 로또 리스트
     * @return 구입된 로또
     */
    public Lottos buyLottosByMoney(int money, List<Lotto> manualLottos) {
        int restMoney = money - (manualLottos.size() * DEFAULT_TICKET_PRICE);
        validBuyLottosByMoney(restMoney);
        return lottoGenerator.generateByTimesAndManualLotto(restMoney / DEFAULT_TICKET_PRICE, manualLottos);
    }

    public Lotto getLottoByLottoNumbers(String lottoNumbers) {
        return new Lotto(this.lottoGenerator.generateLottoNos(lottoNumbers));
    }

    public LottoResult getResultComparedToWinningNumbers(Lotto lotto, int bonus, Lottos lottos) {
        LottoWinningNos lottoWinning = this.lottoGenerator.generateLottoWinningNos(lotto, bonus);
        return LottoResult.getLottoResultFromLotto(lottos, lottoWinning);
    }

    /**
     * 구입할 로또 금액 유효성 검사
     *
     * @param money 구입할 로또 금액
     */
    public void validBuyLottosByMoney(int money) {
        if (money < DEFAULT_TICKET_PRICE) {
            throw new RuntimeException(DEFAULT_TICKET_PRICE - money + "만큼 부족합니다.");
        }
    }

    /**
     * 구입 가능 수동 로또 금액 유효성 검사
     *
     * @param manualLottosCount 구입할 수동 로또 개수
     */
    public void validManualLottosCount(int money, int manualLottosCount) {
        if (money < DEFAULT_TICKET_PRICE * manualLottosCount) {
            throw new RuntimeException("수동 구매가 가능한 로또 개수는 최대 " + (money / DEFAULT_TICKET_PRICE) + "개 까지 구매가 가능합니다.");
        }
    }
}
