package lotto.domain;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoCalculator {

    public static final int LOTTO_PRICE = 1_000;
    public static final int PROFIT_RATE = 1;

    private final Lottos lottos;
    private WinningResults winningResults;

    public LottoCalculator(PurchaseAmount purchaseAmount, Lottos manualLottos) {
        validate(purchaseAmount, manualLottos);
        this.lottos = generateLottos(purchaseAmount, manualLottos);
    }

    public LottoCalculator(PurchaseAmount purchaseAmount, WinningResults winningResults) {
        this(purchaseAmount, new Lottos(new ArrayList<>(), 0));
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

    public int getTotalQuantity() {
        return lottos.getQuantity();
    }

    public int getAutoQuantity() {
        return lottos.getQuantity() - lottos.getManualQuantity();
    }

    public int getManualQuantity() {
        return lottos.getManualQuantity();
    }

    public float getProceedsRate() {
        return (float) winningResults.getProceeds() / ((float) getTotalQuantity() * LOTTO_PRICE);
    }

    private void validate(PurchaseAmount purchaseAmount, Lottos manualLottos) {
        if (!purchaseAmount.isAvailableManualQuantity(manualLottos)) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_CALCULATOR_MANUAL_OVER_ERROR.getMessage());
        }
    }

    private Lottos generateLottos(PurchaseAmount purchaseAmount, Lottos manualLottos) {
        int autoQuantity = purchaseAmount.getQuantity() - manualLottos.getQuantity();
        return Lottos.of(getAutoLottos(purchaseAmount, autoQuantity), manualLottos);
    }

    private Lottos getAutoLottos(PurchaseAmount purchaseAmount, int autoQuantity) {
        return IntStream.range(0, autoQuantity)
                .mapToObj(ignore -> LottoGenerator.generate())
                .collect(Collectors.collectingAndThen(Collectors.toList(),
                        lottos1 -> new Lottos(lottos1, purchaseAmount.getQuantity() - autoQuantity)));
    }
}
