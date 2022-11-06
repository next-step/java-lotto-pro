package lotto.domain;

import lotto.constants.Rank;
import lotto.util.InputValidator;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Lottos {

    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos from(List<Lotto> lottos) {
        return new Lottos(lottos);
    }

    public LottoResult findWinner(Lotto winningNumbers, LottoNumber bonusBall) {
        InputValidator.validateDuplicateBonusBall(winningNumbers, bonusBall);
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

    public Lottos addAll(Lottos lottos) {
        this.lottos.addAll(lottos.getLottos());
        return from(this.lottos);
    }

}