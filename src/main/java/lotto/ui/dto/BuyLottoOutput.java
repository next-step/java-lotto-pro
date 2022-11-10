package lotto.ui.dto;

import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.lotto.Lotto;

public class BuyLottoOutput {
    private final List<Lotto> lottos;
    private final int playerPickCount;

    public BuyLottoOutput(List<Lotto> lottos, int playerPickCount) {
        this.lottos = lottos;
        this.playerPickCount = playerPickCount;
    }

    public List<BoughtLotto> getBoughtLottos() {
        return lottos.stream()
                .map(Lotto::toInts)
                .map(BoughtLotto::new)
                .collect(Collectors.toList());
    }

    /**
     * 수동으로 많이 골랐다 하더라도 지불한 금액보다 많이 살 수 없기 때문에, 아래와 같은 계산 결과가 도출됩니다.
     */
    public int getPlayerPickCount() {
        return Math.min(this.playerPickCount, this.lottos.size());
    }

    public int getQuickPickCount() {
        return this.lottos.size() - getPlayerPickCount();
    }
}
