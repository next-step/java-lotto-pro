package study.step4.models;

import java.util.EnumMap;
import java.util.Map;

public class IntegratedLottos {
    private final Lottos manualLottos;
    private final Lottos autoLottos;

    public IntegratedLottos(Lottos manualLottos, Lottos autoLottos) {
        this.manualLottos = manualLottos;
        this.autoLottos = autoLottos;
    }

    public Map<Rank, Integer> findWinningLottos(WinningLotto winningLotto) {
        Map<Rank, Integer> winningLottosInManualLottos = manualLottos.findWinningLottos(winningLotto);
        Map<Rank, Integer> winningLottosInAutoLottos = autoLottos.findWinningLottos(winningLotto);
        winningLottosInAutoLottos.forEach((rank, value) -> winningLottosInManualLottos.merge(rank, value, (v1, v2) -> v1 + v2));
        return new EnumMap<>(winningLottosInManualLottos);
    }

    public int manualSize() {
        return manualLottos.size();
    }

    public int autoSize() {
        return autoLottos.size();
    }

    public Lottos getManualLottos() {
        return manualLottos;
    }

    public Lottos getAutoLottos() {
        return autoLottos;
    }
}
