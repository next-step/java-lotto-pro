package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottosMap {

    private final Map<LottoType, Lottos> lottos = new HashMap<>();

    public void put(LottoType type, Lottos lottos) {
        this.lottos.put(type, lottos);
    }

    public Lottos getLottos(LottoType type) {
        return this.lottos.get(type);
    }

    public int size(LottoType type) {
        return this.lottos.get(type).getLottos().size();
    }
}
