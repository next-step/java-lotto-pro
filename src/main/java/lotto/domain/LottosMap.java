package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottosMap {

    private final Map<String, Lottos> lottos = new HashMap<>();

    public void putManualLottos(Lottos lottos) {
        this.lottos.put("manual", lottos);
    }

    public Lottos getManualLottos() {
        return this.lottos.get("manual");
    }

    public void putAutoLottos(Lottos lottos) {
        this.lottos.put("auto", lottos);
    }

    public Lottos getAutoLottos() {
        return this.lottos.get("auto");
    }
}
