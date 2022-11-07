package step3.service;

import step3.model.LottoResult;
import step3.model.LottoWinningNumber;
import step3.model.Lottos;

public class LottoService {
    private static final int DEFAULT_TICKET_PRICE = 1000;

    private LottoGenerator lottoGenerator;

    public LottoService() {
        this.lottoGenerator = new LottoGenerator();
    }

    public Lottos buyLottosByMoney(int money) {
        if (money < DEFAULT_TICKET_PRICE) {
            throw new RuntimeException(DEFAULT_TICKET_PRICE - money + "만큼 부족합니다.");
        }

        return lottoGenerator.generateByTimes(money / DEFAULT_TICKET_PRICE);
    }

    public LottoResult getResultComparedToWinningNumbers(String winningLottoText, int bonus, Lottos lottos) {
        LottoWinningNumber lottoWinning = this.lottoGenerator.generateLottoWinningNumber(winningLottoText, bonus);
        return LottoResult.getLottoResultFromLotto(lottos, lottoWinning);
    }
}
