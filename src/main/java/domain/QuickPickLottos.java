package domain;

import domain.strategy.RandomNumberGenerateStrategy;

import java.util.ArrayList;
import java.util.List;

public class QuickPickLottos {
    private final List<Lotto> quickPickLottos;

    public static QuickPickLottos of(int price) {
        List<Lotto> quickPickLottos = new ArrayList<>();
        for (int i = price; i >= Lotto.SELL_PRICE; i -= Lotto.SELL_PRICE) {
            quickPickLottos.add(new Lotto(RandomNumberGenerateStrategy.DEFAULT));
        }
        return new QuickPickLottos(quickPickLottos);
    }

    public int size() {
        return quickPickLottos.size();
    }

    private QuickPickLottos(List<Lotto> quickPickLottos) {
        this.quickPickLottos = quickPickLottos;
    }
}
