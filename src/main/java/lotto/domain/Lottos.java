package lotto.domain;

import lotto.service.LottoIssuedService;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private List<Lotto> lottos;

    public Lottos( LottoIssuedService lottoIssuedService, int lottoPurchaseCount) {
        this.lottos = new ArrayList<>();
        for (int i = 0; i < lottoPurchaseCount; i++)
            this.lottos.add(new Lotto(lottoIssuedService.issueLottoNumber()));
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
