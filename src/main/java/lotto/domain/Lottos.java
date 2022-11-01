package lotto.domain;

import lotto.constants.Rank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Lottos {

    private final List<Lotto> lottos;

    //test를 위한 생성자
    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public Lottos(int lottoAmount) {
        lottos = new ArrayList<>();
        for (int i = 0; i < lottoAmount; i++) {
            Lotto lotto = new Lotto();
            lottos.add(lotto);
        }
    }

    public LottoResult findWinner(Lotto winningNumbers, LottoNumber bonusBall) {
        HashMap<Rank, Integer> lottoResult = new HashMap<>();
        for (Lotto lotto : lottos) {
            Rank collectNumber = lotto.countCollectNumber(winningNumbers, bonusBall);
            lottoResult.put(collectNumber, lottoResult.getOrDefault(collectNumber, 0) + 1);
        }
        return new LottoResult(lottoResult);
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }
}