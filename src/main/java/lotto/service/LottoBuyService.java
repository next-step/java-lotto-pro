package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoPayment;
import lotto.strategy.LottoNumberStrategy;

import java.util.ArrayList;
import java.util.List;

public class LottoBuyService {

    private LottoPayment lottoPayment;
    private LottoNumberStrategy lottoNumberStrategy;

    public LottoBuyService(LottoPayment lottoPayment, LottoNumberStrategy lottoNumberStrategy){
        this.lottoPayment = lottoPayment;
        this.lottoNumberStrategy = lottoNumberStrategy;
    }

    public List<Lotto> generateLottos() {
        int count = getCount();
        List<Lotto> lottos = new ArrayList<>();
        for(int i=0; i<count; i++){
            lottos.add(Lotto.create(lottoNumberStrategy.generateNumbers()));
        }
        return lottos;
    }

    public int getCount() {
        return this.lottoPayment.buyLotto();
    }
}
