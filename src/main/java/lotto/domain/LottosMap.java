package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottosMap {

    private final Map<String, Lottos> lottos = new HashMap<>();

    public void putManualLottos(Lottos manualLottos) {
        this.lottos.put("manual", manualLottos);
    }

    public Lottos getManualLottos() {
        return this.lottos.get("manual");
    }
}
