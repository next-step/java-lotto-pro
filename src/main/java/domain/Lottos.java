package domain;

import domain.strategy.RandomNumberGenerateStrategy;

import java.util.List;

public class Lottos {
    private final SelfPickLottos selfPickLottos;
    private final QuickPickLottos quickPickLottos;

    public Lottos(SelfPickLottos selfPickLottos, QuickPickLottos quickPickLottos) {
        this.selfPickLottos = selfPickLottos;
        this.quickPickLottos = quickPickLottos;
    }

    public static Lottos createLottos(SelfPickLottos selfPickLottos, int money) {
        QuickPickLottos quickPickLottos = QuickPickLottos.of(money - selfPickLottos.price(),
                RandomNumberGenerateStrategy.DEFAULT);
        return new Lottos(selfPickLottos, quickPickLottos);
    }

    public int size() {
        return selfPickLottos.size() + quickPickLottos.size();
    }

    public int quickPickLottoSize() {
        return quickPickLottos.size();
    }

    public int selfPickLottoSize() {
        return selfPickLottos.size();
    }

    public WinningResult winningResult(WinningNumber winningNumber) {
        WinningResult selfPickWinningResult = selfPickLottos.winningResult(winningNumber);
        WinningResult quickPickWinningResult = quickPickLottos.winningResult(winningNumber);
        return WinningResult.merge(selfPickWinningResult, quickPickWinningResult);
    }

    public float spentMoney() {
        return size() * Lotto.SELL_PRICE;
    }

    public List<Lotto> getSelfPickLottos() {
        return selfPickLottos.getLottos();
    }

    public List<Lotto> getQuickPickLottos() {
        return quickPickLottos.getLottos();
    }
}
