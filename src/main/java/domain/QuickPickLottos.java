package domain;

import domain.strategy.NumberGenerateStrategy;
import domain.strategy.RandomNumberGenerateStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuickPickLottos {
    private final List<Lotto> lottos;

    private QuickPickLottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static QuickPickLottos of(int money, NumberGenerateStrategy numberGenerateStrategy) {
        List<Lotto> quickPickLottos = new ArrayList<>();
        for (int i = money; i >= Lotto.SELL_PRICE; i -= Lotto.SELL_PRICE) {
            quickPickLottos.add(new Lotto(numberGenerateStrategy));
        }
        return new QuickPickLottos(quickPickLottos);
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
