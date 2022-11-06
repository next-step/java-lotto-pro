package step3.service;

import step3.model.LottoResult;
import step3.model.Lotto;
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

    public LottoResult getResultComparedToLuckyNumbers(String winningLottoText, Lottos lottos) {
        Lotto winningLotto = this.lottoGenerator.generate(winningLottoText);
        return lottos.calculate(winningLotto);
    }
}
