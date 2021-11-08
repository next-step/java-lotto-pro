package lotto.domain;

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
        this(purchaseAmount, Lottos.EMPTY);
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
        return lottos.getTotalQuantity();
    }

    public int getAutoQuantity() {
        return lottos.getAutoQuantity();
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
        return LottosGenerator.generate(purchaseAmount, manualLottos);
    }
}
