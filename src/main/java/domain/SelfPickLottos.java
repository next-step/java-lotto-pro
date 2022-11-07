package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SelfPickLottos {
    private final List<Lotto> selfPickLottos;

    public SelfPickLottos(List<Set<Integer>> selfPickNumbers) {
        List<Lotto> selfPickLottos = new ArrayList<>();
        selfPickNumbers.forEach(selfPickNumber -> {
            selfPickLottos.add(new Lotto(selfPickNumber));
        });
        this.selfPickLottos = selfPickLottos;
    }

    public int price() {
        return selfPickLottos.size() * Lotto.SELL_PRICE;
    }

    public int size() {
        return selfPickLottos.size();
    }
}
