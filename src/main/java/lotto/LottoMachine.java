package lotto;

import lotto.domain.Lottos;
import lotto.service.LottoNumberService;

import java.util.List;

public class LottoMachine {
    private final LottoNumberService numberService = new LottoNumberService();

    public Lottos purchase(int purchasingCount) {
        Lottos lottos = new Lottos();
        for (int i = 0; i < purchasingCount; i++) {
            List<Integer> lottoNumbers = numberService.makeLottoNumbers();
            lottos.addLotto(lottoNumbers);
        }
        return lottos;
    }
}
