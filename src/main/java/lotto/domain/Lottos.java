package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(AutoLottos autoLottos, ManualLottos manualLottos) {
        List<Lotto> auto = autoLottos.getAutoLottos();
        List<Lotto> manual = manualLottos.getManualLottos();
        manual.addAll(auto);
        this.lottos = manual;
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }

    public List<Rank> match(WinningLotto winningLotto) {
        return lottos.stream()
                .map(winningLotto::match)
                .collect(Collectors.toList());
    }
}
