package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottoList) {
        this.lottos = lottoList;
    }

    public List<Lotto> lottos() {
        return Collections.unmodifiableList(lottos);
    }

    public void addLottos(Lottos addLottos) {
        this.lottos.addAll(addLottos.lottos());
    }


    public WinningResult match(WinningLotto winningLotto) {
        WinningResult result = new WinningResult();
        lottos.forEach(lotto -> result.addRank(winningLotto.rank(lotto)));
        return result;
    }
}
