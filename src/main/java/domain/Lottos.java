package domain;

import domain.strategy.RandomNumberGenerateStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos createLottos(int price) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = price; i >= Lotto.SELL_PRICE; i -= Lotto.SELL_PRICE) {
            lottos.add(new Lotto(RandomNumberGenerateStrategy.DEFAULT));
        }
        return new Lottos(lottos);
    }

    public int size() {
        return lottos.size();
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }

    public WinningResult winningResult(WinningNumber winningNumber) {
        WinningResult winningResult = new WinningResult();
        for (Lotto lotto : lottos) {
            LottoWinning lottoWinning = lotto.findWinning(winningNumber);
            winningResult.increment(lottoWinning);
        }
        return winningResult;
    }

    public float spentMoney() {
        return size() * Lotto.SELL_PRICE;
    }
}
