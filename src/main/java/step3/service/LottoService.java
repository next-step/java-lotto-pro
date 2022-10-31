package step3.service;

import step3.domain.Lotto;
import step3.domain.LottoResult;
import step3.strategy.AutoLottoNumberStrategy;
import step3.strategy.LottoNumberStrategy;

import java.util.List;

public class LottoService {

    private List<Lotto> lottos;
    private Lotto winning;
    private LottoNumberStrategy lottoNumberStrategy;
    public LottoService(){}

    public LottoService(List<Lotto> lottos, Lotto winning) {
        this.lottos = lottos;
        this.winning = winning;
        this.lottoNumberStrategy = new AutoLottoNumberStrategy();
    }

    public LottoService(List<Lotto> lottos, LottoNumberStrategy lottoNumberStrategy) {
        this.lottos = lottos;
        this.lottoNumberStrategy = lottoNumberStrategy;
        this.winning = generateWinningLotto();
    }

    public LottoService(List<Lotto> lottos, Lotto winning, LottoNumberStrategy lottoNumberStrategy) {
        this.lottos = lottos;
        this.winning = winning;
        this.lottoNumberStrategy = lottoNumberStrategy;
    }

    public Lotto generateWinningLotto() {
        return Lotto.create(lottoNumberStrategy.generateNumbers());
    }

    public LottoResult matched(){
        LottoResult result = new LottoResult();

        for (Lotto lotto : lottos) {
            result.addLottoResult(lotto.containNumberCount(winning), lotto);
        }

        return result;
    }
}
