package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoCalculator {

    public static final int LOTTO_PRICE = 1_000;
    public static final int PROFIT_RATE = 1;

    private final Lottos lottos;
    private WinningResults winningResults;

    public LottoCalculator(PurchaseAmount purchaseAmount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < purchaseAmount.getQuantity(); i++) {
            lottos.add(LottoGenerator.generate());
        }
        this.lottos = new Lottos(lottos);
    }

    public LottoCalculator(PurchaseAmount purchaseAmount, WinningResults winningResults) {
        this(purchaseAmount);
        this.winningResults = winningResults;
    }

    public Lottos getLottos() {
        return lottos;
    }

    public WinningResults getWinningResults() {
        return winningResults;
    }

    public void calculate(WinningLotto winningLotto) {
        this.winningResults = lottos.getWinningResults(winningLotto);
    }

    public int getLottosSize() {
        return lottos.size();
    }

    public float getProceedsRate() {
        return (float) winningResults.getProceeds() / ((float) getLottosSize() * LOTTO_PRICE);
    }
}
