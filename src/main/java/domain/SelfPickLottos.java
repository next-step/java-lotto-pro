package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class SelfPickLottos {
    private final List<Lotto> lottos;

    public SelfPickLottos(List<Set<Integer>> selfPickNumbers) {
        List<Lotto> selfPickLottos = new ArrayList<>();
        selfPickNumbers.forEach(selfPickNumber -> {
            selfPickLottos.add(new Lotto(selfPickNumber));
        });
        this.lottos = selfPickLottos;
    }

    public int price() {
        return lottos.size() * Lotto.SELL_PRICE;
    }

    public int size() {
        return lottos.size();
    }

    public WinningResult winningResult(WinningNumber winningNumber) {
        return WinningResult.of(lottos, winningNumber);
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }
}
