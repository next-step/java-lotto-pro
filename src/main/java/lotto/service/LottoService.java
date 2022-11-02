package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.strategy.LottoNumberStrategy;

import java.util.List;

public class LottoService {
    private LottoNumberStrategy lottoNumberStrategy;

    public LottoService(LottoNumberStrategy lottoNumberStrategy) {
        this.lottoNumberStrategy = lottoNumberStrategy;
    }

    public Lotto generateWinningLotto() {
        return Lotto.create(lottoNumberStrategy.generateNumbers());
    }

    public LottoResult matched(List<Lotto> lottos, Lotto winning){
        LottoResult result = new LottoResult();

        for (Lotto lotto : lottos) {
            result.addLottoResult(lotto.getContainNumberCount(winning));
        }

        return result;
    }
}
