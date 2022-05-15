package lotto;

import lotto.domain.Lottos;
import lotto.service.LottoMoneyService;
import lotto.service.LottoNumberService;

import java.util.List;

public class LottoMachine {
    private final LottoMoneyService moneyService = new LottoMoneyService();
    private final LottoNumberService numberService = new LottoNumberService();


    public Lottos purchase(int money) {
        Lottos lottos = new Lottos();
        int purchasingCount = moneyService.calculatePurchasingCount(money);
        for (int i = 0; i < purchasingCount; i++) {
            List<Integer> lottoNumbers = numberService.makeLottoNumbers();
            lottos.addLotto(lottoNumbers);
        }
        return lottos;
    }
}
