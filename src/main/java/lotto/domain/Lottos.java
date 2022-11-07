package lotto.domain;

import java.util.Collections;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottoList) {
        this.lottos = lottoList;
    }

    public List<Lotto> lottos() {
        return Collections.unmodifiableList(lottos);
    }

    public void addLottos(List<Lotto> lottoList) {
        this.lottos.addAll(lottoList);
    }

    public void addLottos(Lottos addLottos) {
        this.lottos.addAll(addLottos.lottos());
    }
}
