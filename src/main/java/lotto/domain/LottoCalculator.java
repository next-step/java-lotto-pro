package lotto.domain;

public class LottoCalculator {

    public static final int LOTTO_PRICE = 1_000;
    public static final int PROFIT_RATE = 1;

    private final Lottos lottos;
    private WinResults winResults;

    public LottoCalculator(PurchaseAmount purchaseAmount) {
        this.lottos = Lottos.fromQuantity(purchaseAmount.getQuantity());
    }

    public Lottos getLottos() {
        return lottos;
    }

    public WinResults getWinResults() {
        return winResults;
    }

    public void calculate(Lotto winNumber) {
        this.winResults = lottos.getWinResults(winNumber);
    }

    public int getLottosSize() {
        return lottos.size();
    }

    public float getProceedsRate() {
        return (float) winResults.getProceeds() / ((float) getLottosSize() * LOTTO_PRICE);
    }
}
