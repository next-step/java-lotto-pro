package step4.service;

import step4.model.LottoNumber;
import step4.model.LottoResult;
import step4.model.LottoWinningNumbers;
import step4.model.Lottos;

import java.util.List;

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

    public List<LottoNumber> getLottoNumbers(String winningLottoText) {
        return this.lottoGenerator.generateLottoNumbers(winningLottoText);
    }

    public LottoResult getResultComparedToWinningNumbers(List<LottoNumber> lottoNumbers, int bonus, Lottos lottos) {
        LottoWinningNumbers lottoWinning = this.lottoGenerator.generateLottoWinningNumber(lottoNumbers, bonus);
        return LottoResult.getLottoResultFromLotto(lottos, lottoWinning);
    }
}
