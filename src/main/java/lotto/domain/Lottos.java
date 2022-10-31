package lotto.domain;

import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(int lottoAmount) {
        lottos = new ArrayList<>();
        for (int i = 0; i < lottoAmount; i++) {
            Lotto lotto = new Lotto();
            lottos.add(lotto);
        }
    }

    public LottoResult findWinner(Lotto winningNumbers) {
        LottoResult lottoResult = new LottoResult();
        for (Lotto lotto : lottos) {
            int collectNumber = lotto.countCollectNumber(winningNumbers);
            lottoResult.putLottoResult(collectNumber);
        }
        return lottoResult;
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }
}