package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lotto.constants.Matched;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(final List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public Lottos(final LottosManual lottosManual) {
        this.lottos = createLottosManual(lottosManual);
    }

    public Lottos(final int lottoCount) {
        this.lottos = createLottosAuto(lottoCount);
    }

    private List<Lotto> createLottosManual(final LottosManual lottosManual) {
        final List<Lotto> lottos = new ArrayList<>();
        final List<List<Integer>> manualLottos = lottosManual.getManualLottos();
        manualLottos.forEach(manualLotto -> lottos.add(new Lotto(manualLotto)));
        return lottos;
    }

    private List<Lotto> createLottosAuto(final int lottoCount) {
        final List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(new Lotto());
        }
        return lottos;
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }

    public int getLottosCount() {
        return lottos.size();
    }

    public List<Matched> matchWinningNumber(final LottoWinningNumbers winningNumbers) {
        return lottos.stream()
                .map(lotto ->
                        lotto.matchesWinningNumber(winningNumbers)
                )
                .collect(
                        Collectors.toList()
                );
    }
}
