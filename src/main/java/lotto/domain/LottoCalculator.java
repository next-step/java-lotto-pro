package lotto.domain;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoCalculator {

    public static final int LOTTO_PRICE = 1_000;
    public static final int PROFIT_RATE = 1;

    private final Lottos lottos;
    private WinningResults winningResults;

    public LottoCalculator(PurchaseAmount purchaseAmount) {
        this.lottos = generateLottos(purchaseAmount);
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

    private Lottos generateLottos(PurchaseAmount purchaseAmount) {
        return IntStream.range(0, purchaseAmount.getQuantity())
                .mapToObj(ignore -> LottoGenerator.generate())
                .collect(Collectors.collectingAndThen(Collectors.toList(), Lottos::new));
    }
}
