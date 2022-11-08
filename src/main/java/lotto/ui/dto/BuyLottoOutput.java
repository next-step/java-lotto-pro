package lotto.ui.dto;

import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.lotto.Lotto;

public class BuyLottoOutput {
    private final List<Lotto> lottos;

    public BuyLottoOutput(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<BoughtLotto> getBoughtLottos() {
        return lottos.stream()
                .map(Lotto::toInts)
                .map(BoughtLotto::new)
                .collect(Collectors.toList());
    }

}
