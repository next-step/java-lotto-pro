package lottoauto.service;

import lottoauto.domain.Lotto;
import lottoauto.domain.LottoResult;
import lottoauto.strategy.AutoLottoNumberStrategy;
import lottoauto.strategy.LottoNumberStrategy;

import java.util.List;

public class LottoService {

    private List<Lotto> lottos;
    private Lotto winning;
    private LottoNumberStrategy lottoNumberStrategy;

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

    public Lotto generateWinningLotto() {
        return Lotto.create(lottoNumberStrategy.generateNumbers());
    }

    public LottoResult matched(){
        LottoResult result = new LottoResult();

        for (Lotto lotto : lottos) {
            result.addLottoResult(lotto.getContainNumberCount(winning));
        }

        return result;
    }
}
